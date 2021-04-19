package com.saihou.mapper;

import com.saihou.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
@Repository("productMapper")
public interface ProductMapper {

    List<Product> findAll();

    Product findById(Integer id);

    Product findByCid(Integer id);

    int insert(Product product);

    int update(Product product);

    int delete(Integer id);

}