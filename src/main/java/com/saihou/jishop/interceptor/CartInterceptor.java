package com.saihou.jishop.interceptor;

import com.saihou.jishop.entity.OrderItem;
import com.saihou.jishop.entity.User;
import com.saihou.jishop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ショッピングカートの商品数など
 *
 * @author saihou
 * @date 2021/04/25
 */
public class CartInterceptor implements HandlerInterceptor {

    @Autowired
    private OrderItemService orderItemService;

    /**
     * ビューのレンダリング前に
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int cartNum = 0;

        if (user != null) {
            List<OrderItem> orderItems = orderItemService.findByUid(user.getId());

            cartNum = orderItems.size();
        }

        session.setAttribute("cartNum", cartNum);
    }
}
