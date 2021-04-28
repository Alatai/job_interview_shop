package com.saihou.service;

import com.saihou.entity.Category;
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

    List<Product> findByCid(Integer id);

    List<Product> findByKeyword(String keyword);

    int insert(Product product);

    int update(Product product);

    int delete(Integer id);

    /**
     * 分類を基に、関連している商品を検索
     */
    void fillRows(List<Category> categories);

    Product productDetail(Integer id);

    List<Product> getSearchResult(String keyword);
}
