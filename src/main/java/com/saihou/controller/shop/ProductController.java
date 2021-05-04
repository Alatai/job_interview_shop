package com.saihou.controller.shop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Product;
import com.saihou.entity.PropertyValue;
import com.saihou.entity.Review;
import com.saihou.service.ProductService;
import com.saihou.service.PropertyValueService;
import com.saihou.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author saihou
 * @date 2021/04/21
 */
@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection"})
@Controller("shopProductController")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/detail")
    public String productDetail(Model model, Integer id) {
        Product product = productService.productDetail(id);
        List<PropertyValue> propertyValues = propertyValueService.findByPid(id);
        List<Review> reviews = reviewService.findByPid(id);

        model.addAttribute("product", product);
        model.addAttribute("propertyValues", propertyValues);
        model.addAttribute("reviews", reviews);
        model.addAttribute("title", product.getName());

        return "/shop/product/detail";
    }

    @RequestMapping("/search")
    public String search(Model model, Integer currentPage, String keyword) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 10);

        List<Product> products = productService.getSearchResult(keyword);
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        String pageParam = "&keyword=" + keyword;

        model.addAttribute("products", products);
        model.addAttribute("title", keyword);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageParam", pageParam);

        return "/shop/product/results";
    }

    @RequestMapping("/searchByCid")
    public String searchByCid(Model model, Integer currentPage, Integer cid) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 5);

        List<Product> products = productService.findByCid(cid);
        String categoryName = products.get(0).getCategory().getName();
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        String pageParam = "&cid=" + cid;

        model.addAttribute("products", products);
        model.addAttribute("title", categoryName);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageParam", pageParam);

        return "/shop/product/results";
    }
}
