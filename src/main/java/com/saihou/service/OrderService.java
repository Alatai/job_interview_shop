package com.saihou.service;

import com.saihou.entity.Order;

import java.util.List;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/20
 */
public interface OrderService {

    String WAIT_PAY = "waitPay";
    String WAIT_DELIVER = "waitDelivery";
    String WAIT_CONFIRM = "waitConfirm";
    String WAIT_REVIEW = "waitReview";
    String FINISHED = "finish";
    String DELETED = "delete";

    List<Order> findAll();

    Order findById(Integer id);

    int insert(Order order);

    int update(Order order);

    int delete(Long id);

    void deliver(Integer id);
}
