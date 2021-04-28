package com.saihou.service;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import com.saihou.entity.User;

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

    List<OrderItem> findByOid(Integer oid);

    List<OrderItem> findByUid(Integer uid);

    List<OrderItem> findByPid(Integer pid);

    int insert(OrderItem orderItem);

    int update(OrderItem orderItem);

    int delete(Integer id);

    /**
     * オーダー金額計算-list
     */
    void calculateAll(List<Order> orders);

    /**
     * オーダー金額計算
     */
    void calculate(Order order);

    /**
     * この商品は既に追加しているかを確認する
     */
    int checkOrderItem(User user, Integer pid, Integer num);

    int getSaleCount(Integer pid);
}
