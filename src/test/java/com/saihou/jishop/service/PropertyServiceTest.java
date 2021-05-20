package com.saihou.jishop.service;

import com.saihou.jishop.entity.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author saihou
 * @date 2021/04/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-core.xml"})
public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;

    @Test
    public void testFindAll() {
        List<Property> properties = propertyService.findAll();

        for (Property property : properties) {
            System.out.println(property);
            System.out.println(property.getCategory());
        }
    }
}
