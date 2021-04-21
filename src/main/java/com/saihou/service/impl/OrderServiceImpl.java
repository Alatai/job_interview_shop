package com.saihou.service.impl;

import com.saihou.entity.Order;
import com.saihou.mapper.OrderMapper;
import com.saihou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/20
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderMapper")
    private OrderMapper orderMapper;


    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.findById(id);
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
    public int delete(Long id) {
        return orderMapper.delete(id);
    }

    @Override
    public void deliver(Integer id) {
        Order order = orderMapper.findById(id);
        order.setDeliveredDate(new Date());
        order.setStatus(WAIT_CONFIRM);

        orderMapper.update(order);
    }
}
