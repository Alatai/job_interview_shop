package com.saihou.service.impl;

import com.saihou.entity.Property;
import com.saihou.mapper.PropertyMapper;
import com.saihou.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性
 *
 * @author saihou
 * @date 2021/04/19
 */
@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    @Qualifier("propertyMapper")
    private PropertyMapper propertyMapper;

    @Override
    public List<Property> findAll() {
        return propertyMapper.findAll();
    }

    @Override
    public Property findById(Integer id) {
        return propertyMapper.findById(id);
    }

    @Override
    public Property findByCid(Integer cid) {
        return propertyMapper.findByCid(cid);
    }

    @Override
    public int insert(Property property) {
        return propertyMapper.insert(property);
    }

    @Override
    public int update(Property property) {
        return propertyMapper.update(property);
    }

    @Override
    public int delete(Integer id) {
        return propertyMapper.delete(id);
    }
}
