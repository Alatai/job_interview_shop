package com.saihou.mapper;

import com.saihou.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分類
 *
 * @author saihou
 * @date 2021/04/18
 */
@Repository("categoryMapper")
public interface CategoryMapper {

    List<Category> findAll();

    Category findById(Integer id);

    int insert(Category category);

    int update(Category category);

    int deleteById(Integer id);

}