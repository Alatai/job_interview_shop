package com.saihou.service.impl;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import com.saihou.mapper.OrderItemMapper;
import com.saihou.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * オーダー詳細
 *
 * @author saihou
 * @date 2021/04/20
 */
@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    @Qualifier("orderItemMapper")
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> findAll() {
        return orderItemMapper.findAll();
    }

    @Override
    public OrderItem findById(Integer id) {
        return orderItemMapper.findById(id);
    }

    @Override
    public List<OrderItem> findByOid(Integer id) {
        return orderItemMapper.findByOid(id);
    }

    @Override
    public int insert(OrderItem orderItem) {
        return orderItemMapper.insert(orderItem);
    }

    @Override
    public int update(OrderItem orderItem) {
        return orderItemMapper.update(orderItem);
    }

    @Override
    public int delete(Long id) {
        return orderItemMapper.delete(id);
    }

    @Override
    public void calculateAll(List<Order> orders) {
        for (Order order : orders) {
            calculate(order);
        }
    }

    @Override
    public void calculate(Order order) {
        List<OrderItem> items = orderItemMapper.findByOid(order.getId());

        float amount = 0f;
        int number = 0;

        for (OrderItem item : items) {
            amount += item.getNumber() * item.getProduct().getPromotePrice();
            number += item.getNumber();
        }

        order.setAmount(amount);
        order.setNumber(number);
    }
}
