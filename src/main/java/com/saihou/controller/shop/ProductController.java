package com.saihou.controller.shop;

import com.saihou.entity.Product;
import com.saihou.entity.ProductImage;
import com.saihou.entity.PropertyValue;
import com.saihou.entity.Review;
import com.saihou.service.ProductImageService;
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
    private ProductImageService productImageService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/detail")
    private String getProduct(Model model, Integer id) {
        Product product = productService.findById(id);

        List<ProductImage> singleImages = productImageService.findByCondition(id, ProductImageService.TYPE_SINGLE);
        List<ProductImage> detailImages = productImageService.findByCondition(id, ProductImageService.TYPE_DETAIL);

        product.setSingleImages(singleImages);
        product.setDetailImages(detailImages);

        List<PropertyValue> propertyValues = propertyValueService.findByPid(id);
        List<Review> reviews = reviewService.findByPid(id);

        model.addAttribute("product", product);
        model.addAttribute("propertyValues", propertyValues);
        model.addAttribute("reviews", reviews);

        return "/shop/product/detail";
    }
}
