package com.saihou.controller.shop;

import com.saihou.entity.Order;
import com.saihou.entity.OrderItem;
import com.saihou.entity.User;
import com.saihou.service.OrderItemService;
import com.saihou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/24
 */
@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection"})
@Controller("shopOrderController")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/buyCurrently")
    public String buyCurrently(HttpSession session, Integer pid, Integer num) {
        User user = (User) session.getAttribute("user");

        int orderItemId = orderItemService.checkOrderItem(user, pid, num);

        return "redirect:/order/submitOrder?oiId=" + orderItemId;
    }

    @RequestMapping("/submitOrder")
    public String confirmOrder(HttpSession session, Model model, String[] oiId) {
        List<OrderItem> orderItems = new ArrayList<>();
        float amount = 0;

        for (String id : oiId) {
            OrderItem orderItem = orderItemService.findById(Integer.parseInt(id));
            amount += orderItem.getProduct().getPromotePrice() * orderItem.getNumber();

            orderItems.add(orderItem);
        }

        session.setAttribute("title", "オーダー");
        session.setAttribute("orderItems", orderItems);
        model.addAttribute("amount", amount);

        return "/shop/order/order";
    }

    /**
     * ショッピングカートに追加する
     */
    @RequestMapping("/add2Cart")
    @ResponseBody
    public String add2Cart(HttpSession session, @RequestBody Map<String, Integer> params) {
        Integer pid = params.get("pid");
        Integer num = params.get("num");
        User user = (User) session.getAttribute("user");

        orderItemService.checkOrderItem(user, pid, num);

        return "success";
    }

    /**
     * ショッピングカートに移動する
     */
    @RequestMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.findByUid(user.getId());

        model.addAttribute("title", "ショッピングカート");
        model.addAttribute("orderItems", orderItems);

        return "/shop/order/cart";
    }

    @ResponseBody
    @RequestMapping("/updateCartItem")
    public String updateCartItem(HttpSession session, @RequestBody Map<String, Integer> params) {
        Integer id = params.get("id");
        Integer num = params.get("num");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "fail";
        }

        OrderItem orderItem = orderItemService.findById(id);
        orderItem.setNumber(num);

        orderItemService.update(orderItem);

        return "success";
    }

    @ResponseBody
    @RequestMapping("/deleteCartItem")
    public String deleteCartItem(HttpSession session, @RequestBody Map<String, Integer> params) {
        Integer id = params.get("id");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "fail";
        }

        orderItemService.delete(id);

        return "success";
    }

    /**
     * オーダーの生成、状態付け（waitPay）
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/createOrder")
    public String createOrder(HttpSession session, Order order) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");

        order.setUid(user.getId());
        order = orderService.createOrder(order, orderItems);

        return "redirect:/order/pay?id=" + order.getId() + "&amount=" + order.getAmount();
    }

    /**
     * 支払いページ
     */
    @RequestMapping("/pay")
    public String doPay(Model model, Integer id, Float amount) {
        Order order = orderService.findById(id);
        order.setAmount(amount);

        model.addAttribute("title", "支払い");
        model.addAttribute("order", order);

        return "/shop/order/pay";
    }

    /**
     * 既に支払っている、状態変更（waitDeliver）
     */
    @RequestMapping("/hasPaid")
    public String hasPaid(Integer id) {
        orderService.hasPaid(id);

        return "redirect:/order/paySuccess";
    }

    /**
     * 支払い成功ページに移動
     */
    @RequestMapping("/paySuccess")
    public String paySuccess(Model model) {
        model.addAttribute("title", "支払い成功");

        return "/shop/order/hasPaid";
    }

    /**
     * ユーザオーダーページに移動
     */
    @RequestMapping("/orders")
    public String orders(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        List<Order> orders = orderService.findByUid(user.getId());
        orderItemService.calculateAll(orders);

        model.addAttribute("title", "ユーザオーダー");
        model.addAttribute("orders", orders);

        return "/shop/order/orders";
    }

    /**
     * オーダー確認完成、状態変更（waitReview）
     */
    @RequestMapping("/confirmOrder")
    public String confirmOrder(Integer id) {
        orderService.confirmOrder(id);

        return "redirect:/order/orders";
    }

    /**
     * オーダー削除、状態変更（delete）
     */
    @RequestMapping("/delete")
    public String deleteOrder(Integer id) {
        orderService.deleteOrder(id);

        return "success";
    }
}
