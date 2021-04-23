package com.saihou.controller.shop;

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
        Product product = productService.findById(id);
        List<PropertyValue> propertyValues = propertyValueService.findByPid(id);
        List<Review> reviews = reviewService.findByPid(id);

        System.out.println("-------------");
        System.out.println(propertyValues);
        System.out.println("-------------");

        model.addAttribute("product", product);
        model.addAttribute("propertyValues", propertyValues);
        model.addAttribute("reviews", reviews);

        return "/shop/product/detail";
    }
}
