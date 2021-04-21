package com.saihou.service;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;

import java.util.List;

/**
 * オーダー詳細
 *
 * @author saihou
 * @date 2021/04/20
 */
public interface OrderItemService {

    List<OrderItem> findAll();

    OrderItem findById(Integer id);

    List<OrderItem> findByOid(Integer id);

    int insert(OrderItem orderItem);

    int update(OrderItem orderItem);

    int delete(Long id);

    /**
     * オーダー金額計算-list
     */
    void calculateAll(List<Order> orders);

    /**
     * オーダー金額計算
     */
    void calculate(Order order);
}
