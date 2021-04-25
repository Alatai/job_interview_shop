package com.saihou.controller.shop;

import com.saihou.entity.OrderItem;
import com.saihou.entity.Product;
import com.saihou.entity.User;
import com.saihou.service.OrderItemService;
import com.saihou.service.OrderService;
import com.saihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/24
 */
@Controller("shopOrderController")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/buyCurrently")
    public String buyCurrently(HttpSession session, Integer pid, Integer num) {
        User user = (User) session.getAttribute("user");

        int orderItemId = checkOrderItem(user, pid, num);

        return "redirect:/order/confirmOrder?oiId=" + orderItemId;
    }

    @RequestMapping("/confirmOrder")
    public String confirmOrder(HttpSession session, Model model, String[] oiId) {
        List<OrderItem> orderItems = new ArrayList<>();
        float amount = 0;

        for (String id : oiId) {
            OrderItem orderItem = orderItemService.findById(Integer.parseInt(id));
            amount += orderItem.getProduct().getPromotePrice() * orderItem.getNumber();

            orderItems.add(orderItem);
        }

        session.setAttribute("orderItems", orderItems);
        model.addAttribute("amount", amount);

        return "/shop/order/account";
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

        checkOrderItem(user, pid, num);

        return "success";
    }

    /**
     * ショッピングカートに移動する
     */
    @RequestMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.findByUid(user.getId());

        model.addAttribute("orderItems", orderItems);

        return "/shop/order/cart";
    }

    /**
     * この商品は既に追加しているかを確認する
     */
    private int checkOrderItem(User user, Integer pid, Integer num) {
        Product product = productService.findById(pid);
        List<OrderItem> orderItems = orderItemService.findByUid(user.getId());

        int orderItemId = 0;
        boolean isExist = false;

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().getId().equals(product.getId())) {
                orderItem.setNumber(orderItem.getNumber() + num);
                orderItemService.update(orderItem);

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

            orderItemService.insert(orderItem);
            orderItemId = orderItem.getId();
        }

        return orderItemId;
    }
}
