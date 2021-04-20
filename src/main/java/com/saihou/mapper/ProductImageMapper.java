package com.saihou.mapper;

import com.saihou.entity.ProductImage;
import com.saihou.query.ProductImageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
@Repository("productImageMapper")
public interface ProductImageMapper {

    List<ProductImage> findAll();

    ProductImage findById(Integer id);

    List<ProductImage> findByPid(Integer id);

    List<ProductImage> findByCondition(ProductImageQuery query);

    int insert(ProductImage productImage);

    int update(ProductImage productImage);

    int delete(Integer id);
}