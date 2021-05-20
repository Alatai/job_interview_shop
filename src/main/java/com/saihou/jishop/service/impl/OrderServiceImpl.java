package com.saihou.jishop.service.impl;

import com.saihou.jishop.entity.Order;
import com.saihou.jishop.entity.OrderItem;
import com.saihou.jishop.entity.Product;
import com.saihou.jishop.mapper.OrderMapper;
import com.saihou.jishop.service.OrderItemService;
import com.saihou.jishop.service.OrderService;
import com.saihou.jishop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/20
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderMapper")
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.findById(id);
    }

    @Override
    public List<Order> findByUid(Integer id) {
        return orderMapper.findByUid(id);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public int delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public Order createOrder(Order order, List<OrderItem> orderItems) {
        String orderCode = UUID.randomUUID().toString().replace("-", "");

        order.setStatus(WAIT_PAY);
        order.setOrderCode(orderCode);
        order.setCreatedDate(new Date());

        insert(order);

        float amount = 0;

        // オーダーとオーダー詳細を関連する、総金額計算
        for (OrderItem orderItem : orderItems) {
            orderItem.setOid(order.getId());
            orderItemService.update(orderItem);

            amount += orderItem.getProduct().getPromotePrice() * orderItem.getNumber();
        }

        order.setAmount(amount);

        return order;
    }

    @Override
    public void hasPaid(Integer id) {
        Order order = findById(id);
        order.setStatus(WAIT_DELIVER);
        order.setPaidDate(new Date());

        // 在庫数更新
        List<OrderItem> orderItems = orderItemService.findByOid(id);

        for (OrderItem orderItem : orderItems) {
            Product product = orderItem.getProduct();

            Integer stock = product.getStock();
            stock -= orderItem.getNumber();

            System.out.println("stock: " + stock);

            product.setStock(stock);
            productService.update(product);
        }

        update(order);
    }

    @Override
    public void deliver(Integer id) {
        Order order = orderMapper.findById(id);
        order.setStatus(WAIT_CONFIRM);
        order.setDeliveredDate(new Date());

        update(order);
    }

    @Override
    public Order confirmOrder(Integer id) {
        Order order = findById(id);
        order.setStatus(WAIT_REVIEW);
        order.setConfirmedDate(new Date());

        update(order);

        return order;
    }

    @Override
    public void deleteOrder(Integer id) {
        Order order = findById(id);
        order.setStatus(DELETED);

        update(order);
    }

    @Override
    public void hasReviewed(Integer id) {
        Order order = findById(id);
        order.setStatus(FINISHED);

        update(order);
    }
}
