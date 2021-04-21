package com.saihou.controller.shop;

import com.saihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/search")
    private String search(String keyword) {
        return "";
    }
}
