package com.saihou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Category;
import com.saihou.entity.Property;
import com.saihou.service.CategoryService;
import com.saihou.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品属性
 *
 * @author saihou
 * @date 2021/04/19
 */
@Controller
@RequestMapping("/admin/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/index", "/list"})
    public String list(Model model, Integer currentPage, Integer cid) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 8);

        Category category = categoryService.findById(cid);
        List<Property> properties = category.getProperties();
        PageInfo<Property> pageInfo = new PageInfo<>(properties);

        model.addAttribute("title", "商品属性");
        model.addAttribute("category", category);
        model.addAttribute("properties", properties);
        model.addAttribute("pageInfo", pageInfo);

        return "/admin/property/list";
    }

    @RequestMapping("/add")
    public String add(Property property) {
        propertyService.insert(property);

        return "redirect:/admin/property/list?cid=" + property.getCid();
    }

    @RequestMapping("/update")
    public String update(Property property) {
        propertyService.update(property);

        return "redirect:/admin/property/list?cid=" + property.getCid();
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        Property property = propertyService.findById(id);
        propertyService.delete(id);

        return "redirect:/admin/property/list?cid=" + property.getCid();
    }
}
