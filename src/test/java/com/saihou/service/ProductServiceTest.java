package com.saihou.service;

import com.saihou.entity.Product;
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

    @Test
    public void testFindAll() {
        List<Product> products = productService.findAll();

        for (Product product : products) {
            System.out.println(product);
            System.out.println(product.getCategory());
        }
    }
}
