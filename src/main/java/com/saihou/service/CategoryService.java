package com.saihou.service;

import com.saihou.entity.Category;

import java.util.List;

/**
 * 商品分類
 *
 * @author saihou
 * @date 2021/04/18
 */
public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    int insert(Category category);

    int update(Category category);

    int delete(Integer id);
}
