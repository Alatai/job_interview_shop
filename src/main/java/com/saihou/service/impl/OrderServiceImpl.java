package com.saihou.service.impl;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import com.saihou.entity.Product;
import com.saihou.mapper.OrderMapper;
import com.saihou.service.OrderItemService;
import com.saihou.service.OrderService;
import com.saihou.service.ProductService;
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

    @Override
    public Order createOrder(Order order, List<OrderItem> orderItems) {
        String orderCode = UUID.randomUUID().toString().replace("-", "");

        order.setOrderCode(orderCode);
        order.setCreatedDate(new Date());
        order.setStatus(OrderService.WAIT_PAY);

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
}
