package com.saihou.service;

import com.saihou.entity.Category;
import com.saihou.entity.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author saihou
 * @date 2021/04/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-core.xml"})
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFindAll() {
        List<Category> categories = categoryService.findAll();
        for (Category category : categories) {
            System.out.println(category);
            List<Property> properties = category.getProperties();
            for (Property property : properties) {
                System.out.println(property);
            }
        }
    }

    @Test
    public void testFindById() {
        Category category = categoryService.findById(1);
        System.out.println(category);
        List<Property> properties = category.getProperties();
        for (Property property : properties) {
            System.out.println(property);
        }
    }
}
