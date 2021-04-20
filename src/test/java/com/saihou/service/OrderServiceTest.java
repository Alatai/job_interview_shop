package com.saihou.service;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author saihou
 * @date 2021/04/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-core.xml"})
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void testFindAllOrder() {
        List<Order> orders = orderService.findAll();

        for (Order order : orders) {
            System.out.println(order);
            List<OrderItem> orderItems = orderItemService.findByOid(order.getId());

            for (OrderItem orderItem : orderItems) {
                System.out.println(orderItem);
            }
        }
    }
}
