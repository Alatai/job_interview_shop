package com.saihou.service;

import com.saihou.entity.Product;
import com.saihou.entity.PropertyValue;

import java.util.List;

/**
 * 属性値
 *
 * @author saihou
 * @date 2021/04/20
 */
public interface PropertyValueService {

    PropertyValue findById(Integer id);

    List<PropertyValue> findByPid(Integer pid);

    /**
     * 商品id、属性idを基に、属性値を検索する
     *
     * @param pid  商品id
     * @param ptid 属性id
     * @return 属性値
     */
    PropertyValue findByCondition(Integer pid, Integer ptid);

    int insert(PropertyValue propertyValue);

    int update(PropertyValue propertyValue);

    int delete(Integer id);

    /**
     * 属性値を初期化する
     */
    void init(Product product);
}
