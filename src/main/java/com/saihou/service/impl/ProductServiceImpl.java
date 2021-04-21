package com.saihou.service.impl;

import com.saihou.entity.Category;
import com.saihou.entity.Product;
import com.saihou.mapper.ProductMapper;
import com.saihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;


    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findByCid(Integer id) {
        return productMapper.findByCid(id);
    }

    @Override
    public int insert(Product product) {
        product.setCreatedDate(new Date());

        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int delete(Integer id) {
        return productMapper.delete(id);
    }

    @Override
    public void fillRows(List<Category> categories) {
        int numberForRow = 4;

        for (Category category : categories) {
            List<Product> products = category.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();

            for (int i = 0; i < products.size(); i += numberForRow) {
                int size = i + numberForRow;
                size = Math.min(size, products.size());

                List<Product> productsForRow = products.subList(i, size);
                productsByRow.add(productsForRow);
            }

            category.setProductsByRow(productsByRow);
        }
    }
}
