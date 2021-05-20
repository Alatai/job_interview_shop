package com.saihou.jishop.service;

import com.saihou.jishop.entity.Order;
import com.saihou.jishop.entity.OrderItem;

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

    List<Order> findByUid(Integer id);

    int insert(Order order);

    int update(Order order);

    int delete(Integer id);

    /**
     * オーダーの生成、状態付け（waitPay）
     */
    Order createOrder(Order order, List<OrderItem> orderItems);

    /**
     * 支払い成功、状態変更（waitDeliver)
     */
    void hasPaid(Integer id);

    /**
     * オーダー配達完成、状態変更（waitConfirm）
     */
    void deliver(Integer id);

    /**
     * オーダー確認完成、状態変更（waitReview）
     */
    Order confirmOrder(Integer id);

    /**
     * オーダー削除、状態変更（delete）
     */
    void deleteOrder(Integer id);

    /**
     * オーダー評価完成、状態変更（finish）
     */
    void hasReviewed(Integer id);
}
