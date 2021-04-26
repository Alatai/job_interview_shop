package com.saihou.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Category;
import com.saihou.entity.Product;
import com.saihou.entity.ProductImage;
import com.saihou.service.ProductImageService;
import com.saihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
@SuppressWarnings({"SpringMVCViewInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Controller("productImageController")
@RequestMapping("/admin/image")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/index", "/list"})
    public String list(Model model, Integer currentPage, Integer pid) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 5);

        Product product = productService.findById(pid);
        Category category = product.getCategory();
        List<ProductImage> productImages = product.getProductImages();

        List<ProductImage> singleImages = productImageService.findByCondition(pid, productImageService.TYPE_SINGLE);
        List<ProductImage> detailImages = productImageService.findByCondition(pid, productImageService.TYPE_DETAIL);

        PageInfo<ProductImage> pageInfo = new PageInfo<>(productImages);

        String pageParam = "&pid=" + pid;

        model.addAttribute("title", "商品写真");
        model.addAttribute("product", product);
        model.addAttribute("category", category);
        model.addAttribute("singleImages", singleImages);
        model.addAttribute("detailImages", detailImages);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageParam", pageParam);

        return "/admin/image/list";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, MultipartFile image, ProductImage productImage) {
        // アップロードパス
        String path;

        // 二つのファイルを用意している
        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())) {
            path = request.getSession().getServletContext().getRealPath("/image/single");
        } else {
            path = request.getSession().getServletContext().getRealPath("/image/detail");
        }

        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        // ファイル名を設置する
        String filename = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        try {
            image.transferTo(new File(path, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // データベースに追加
        productImage.setName(filename);
        productImageService.insert(productImage);

        return "redirect:/admin/image/list?pid=" + productImage.getPid();
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        ProductImage productImage = productImageService.findById(id);
        productImageService.delete(id);

        return "redirect:/admin/image/list?pid=" + productImage.getPid();
    }
}
