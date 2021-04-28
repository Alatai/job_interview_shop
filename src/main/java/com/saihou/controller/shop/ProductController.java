package com.saihou.controller.shop;

import com.github.pagehelper.PageHelper;
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
 * @author Alatai
 * @version 1.0
 * @date 2021/04/21 23:11
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
    private String getProduct(Model model, Integer id) {
        Product product = productService.productDetail(id);
        List<PropertyValue> propertyValues = propertyValueService.findByPid(id);
        List<Review> reviews = reviewService.findByPid(id);

        model.addAttribute("product", product);
        model.addAttribute("propertyValues", propertyValues);
        model.addAttribute("reviews", reviews);

        return "/shop/product/detail";
    }

    @RequestMapping("/search")
    private String search(Model model, String keyword) {
        PageHelper.offsetPage(0, 20);
        List<Product> products = productService.getSearchResult(keyword);

        model.addAttribute("products", products);

        return "/shop/product/results";
    }
}
