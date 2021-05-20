package com.saihou.jishop.mapper;

import com.saihou.jishop.entity.PropertyValue;
import com.saihou.jishop.query.BaseQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 属性値
 *
 * @author saihou
 * @date 2021/04/20
 */
@Repository("propertyValueMapper")
public interface PropertyValueMapper {

    PropertyValue findById(Integer id);

    List<PropertyValue> findByPid(Integer pid);

    PropertyValue findByCondition(BaseQuery query);

    int insert(PropertyValue propertyValue);

    int update(PropertyValue propertyValue);

    int delete(Integer id);
}