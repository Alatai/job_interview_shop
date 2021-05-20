package com.saihou.jishop.service;

import com.saihou.jishop.entity.Product;
import com.saihou.jishop.entity.ProductImage;
import com.saihou.jishop.entity.PropertyValue;
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
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyValueService propertyValueService;

    @Test
    public void testFindAll() {
        List<Product> products = productService.findAll();

        for (Product product : products) {
            System.out.println(product);
            System.out.println(product.getCategory());

            List<ProductImage> productImages = product.getProductImages();
            for (ProductImage productImage : productImages) {
                System.out.println(productImage);
            }
        }
    }

    @Test
    public void testFindPropertyValue() {
        List<PropertyValue> propertyValues = propertyValueService.findByPid(1);

        for (PropertyValue propertyValue : propertyValues) {
            System.out.println(propertyValue);
        }
    }

    @Test
    public void testFindByCondition() {
        PropertyValue pv = propertyValueService.findByCondition(1, 6);
        System.out.println(pv);
    }
}
