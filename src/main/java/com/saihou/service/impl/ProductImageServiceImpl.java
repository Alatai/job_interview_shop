package com.saihou.service.impl;

import com.saihou.entity.ProductImage;
import com.saihou.mapper.ProductImageMapper;
import com.saihou.query.ProductImageQuery;
import com.saihou.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
@Service("productImageService")
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    @Qualifier("productImageMapper")
    private ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> findAll() {
        return productImageMapper.findAll();
    }

    @Override
    public ProductImage findById(Integer id) {
        return productImageMapper.findById(id);
    }

    @Override
    public List<ProductImage> findByPid(Integer id) {
        return productImageMapper.findByPid(id);
    }

    @Override
    public List<ProductImage> findByCondition(Integer pid, String type) {
        ProductImageQuery query = new ProductImageQuery();
        query.setPid(pid);
        query.setType(type);

        return productImageMapper.findByCondition(query);
    }

    @Override
    public int insert(ProductImage productImage) {
        return productImageMapper.insert(productImage);
    }

    @Override
    public int update(ProductImage productImage) {
        return productImageMapper.update(productImage);
    }

    @Override
    public int delete(Integer id) {
        return productImageMapper.delete(id);
    }

}
