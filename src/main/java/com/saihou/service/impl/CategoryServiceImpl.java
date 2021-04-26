package com.saihou.service.impl;

import com.saihou.entity.Category;
import com.saihou.mapper.CategoryMapper;
import com.saihou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分類
 *
 * @author saihou
 * @date 2021/04/18 15:41
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    @Qualifier("categoryMapper")
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryMapper.delete(id);
    }
}
