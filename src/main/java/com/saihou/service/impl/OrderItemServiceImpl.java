package com.saihou.service.impl;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import com.saihou.entity.Product;
import com.saihou.entity.User;
import com.saihou.mapper.OrderItemMapper;
import com.saihou.service.OrderItemService;
import com.saihou.service.ProductService;
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
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    @Qualifier("orderItemMapper")
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductService productService;

    @Override
    public List<OrderItem> findAll() {
        return orderItemMapper.findAll();
    }

    @Override
    public OrderItem findById(Integer id) {
        return orderItemMapper.findById(id);
    }

    @Override
    public List<OrderItem> findByOid(Integer oid) {
        return orderItemMapper.findByOid(oid);
    }

    @Override
    public List<OrderItem> findByUid(Integer uid) {
        return orderItemMapper.findByUid(uid);
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
    public int delete(Integer id) {
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

    @Override
    public int checkOrderItem(User user, Integer pid, Integer num) {
        Product product = productService.findById(pid);
        List<OrderItem> orderItems = findByUid(user.getId());

        int orderItemId = 0;
        boolean isExist = false;

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().getId().equals(product.getId())) {
                orderItem.setNumber(orderItem.getNumber() + num);
                update(orderItem);

                isExist = true;
                orderItemId = orderItem.getId();
                break;
            }
        }

        if (!isExist) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUid(user.getId());
            orderItem.setPid(pid);
            orderItem.setNumber(num);

            insert(orderItem);
            orderItemId = orderItem.getId();
        }

        return orderItemId;
    }
}
