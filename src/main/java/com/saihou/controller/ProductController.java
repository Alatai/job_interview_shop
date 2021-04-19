package com.saihou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Category;
import com.saihou.entity.Product;
import com.saihou.entity.Property;
import com.saihou.service.CategoryService;
import com.saihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/index", "/list"})
    public String list(Model model, Integer currentPage, Integer cid) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 8);

        Category category = categoryService.findById(cid);
        List<Product> products = category.getProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        model.addAttribute("title", "商品");
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("pageInfo", pageInfo);

        return "/admin/product/list";
    }

    @RequestMapping("/add")
    public String add(Product product) {
        productService.insert(product);

        return "redirect:/admin/product/list?cid=" + product.getCid();
    }

    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);

        return "redirect:/admin/product/list?cid=" + product.getCid();
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        Product product = productService.findById(id);
        productService.delete(id);

        return "redirect:/admin/product/list?cid=" + product.getCid();
    }

}
