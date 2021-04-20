package com.saihou.service;

import com.saihou.entity.ProductImage;

import java.util.List;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
public interface ProductImageService {

    String TYPE_SINGLE = "type_single"; // 商品写真タイプ
    String TYPE_DETAIL = "type_detail"; // 商品写真タイプ

    List<ProductImage> findAll();

    ProductImage findById(Integer id);

    List<ProductImage> findByPid(Integer pid);

    List<ProductImage> findByCondition(Integer pid, String type);

    int insert(ProductImage productImage);

    int update(ProductImage productImage);

    int delete(Integer id);

}
