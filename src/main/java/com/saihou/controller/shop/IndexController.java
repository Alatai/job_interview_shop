package com.saihou.controller.shop;

import com.saihou.entity.Category;
import com.saihou.entity.User;
import com.saihou.service.CategoryService;
import com.saihou.service.ProductService;
import com.saihou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @author saihou
 * @date 2021/04/21
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        productService.fillRows(categories);

        model.addAttribute("title", "jishop");
        model.addAttribute("categories", categories);

        return "shop/home/index";
    }

}
