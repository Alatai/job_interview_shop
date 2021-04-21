package com.saihou.controller.admin;

import com.saihou.entity.Product;
import com.saihou.entity.PropertyValue;
import com.saihou.service.ProductService;
import com.saihou.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 属性値
 *
 * @author saihou
 * @date 2021/04/20
 */
@Controller("propertyValueController")
@RequestMapping("/admin/pvalue")
public class PropertyValueController {

    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/edit")
    public String edit(Model model, Integer pid) {
        Product product = productService.findById(pid);
        // 商品を基に属性値を初期化する
        propertyValueService.init(product);
        List<PropertyValue> propertyValues = propertyValueService.findByPid(pid);

        model.addAttribute("propertyValues", propertyValues);
        model.addAttribute("product", product);
        model.addAttribute("category", product.getCategory());

        return "/admin/pvalue/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(@RequestBody List<PropertyValue> propertyValues) {
        for (PropertyValue propertyValue : propertyValues) {
            propertyValueService.update(propertyValue);
        }

        return "success";
    }
}
