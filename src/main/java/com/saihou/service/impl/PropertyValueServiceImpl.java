package com.saihou.service.impl;

import com.saihou.entity.Product;
import com.saihou.entity.Property;
import com.saihou.entity.PropertyValue;
import com.saihou.mapper.PropertyValueMapper;
import com.saihou.query.PropertyValueQuery;
import com.saihou.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/20 14:36
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("propertyValueService")
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    @Qualifier("propertyValueMapper")
    private PropertyValueMapper propertyValueMapper;

    @Override
    public PropertyValue findById(Integer id) {
        return propertyValueMapper.findById(id);
    }

    @Override
    public List<PropertyValue> findByPid(Integer pid) {
        return propertyValueMapper.findByPid(pid);
    }

    @Override
    public PropertyValue findByCondition(Integer pid, Integer ptid) {
        PropertyValueQuery query = new PropertyValueQuery();
        query.setPid(pid);
        query.setPtid(ptid);

        return propertyValueMapper.findByCondition(query);
    }

    @Override
    public int insert(PropertyValue propertyValue) {
        return propertyValueMapper.insert(propertyValue);
    }

    @Override
    public int update(PropertyValue propertyValue) {
        return propertyValueMapper.update(propertyValue);
    }

    @Override
    public int delete(Integer id) {
        return propertyValueMapper.delete(id);
    }

    @Override
    public void init(Product product) {
        List<Property> properties = product.getCategory().getProperties();

        for (Property property : properties) {
            PropertyValue propertyValue = findByCondition(product.getId(), property.getId());

            if (propertyValue == null) {
                propertyValue = new PropertyValue();
                propertyValue.setPid(product.getId());
                propertyValue.setPtid(property.getId());

                propertyValueMapper.insert(propertyValue);
            }
        }
    }

}
