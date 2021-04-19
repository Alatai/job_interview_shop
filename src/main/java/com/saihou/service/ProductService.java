package com.saihou.service;

import com.saihou.entity.Product;

import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    Product findByCid(Integer id);

    int insert(Product product);

    int update(Product product);

    int delete(Integer id);

}
