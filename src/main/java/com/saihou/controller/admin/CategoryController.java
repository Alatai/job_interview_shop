package com.saihou.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Category;
import com.saihou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品分類
 *
 * @author saihou
 * @date 2021/04/18
 */
@Controller("categoryController")
@RequestMapping("/admin/category")
public class
CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/index", "/list"})
    public String list(Model model, Integer currentPage) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 8);
        List<Category> categories = categoryService.findAll();
        PageInfo<Category> pageInfo = new PageInfo<>(categories);

        model.addAttribute("title", "商品分類");
        model.addAttribute("categories", categories);
        model.addAttribute("pageInfo", pageInfo);

        return "/admin/category/list";
    }

    @RequestMapping("/add")
    public String add(Category category) {
        categoryService.insert(category);

        return "redirect:/admin/category/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        categoryService.delete(id);

        return "redirect:/admin/category/list";
    }

    @RequestMapping("/update")
    public String update(Category category) {
        categoryService.update(category);

        return "redirect:/admin/category/list";
    }
}
