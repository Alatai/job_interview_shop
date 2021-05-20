package com.saihou.jishop.controller.shop;

import com.saihou.jishop.entity.Order;
import com.saihou.jishop.entity.OrderItem;
import com.saihou.jishop.entity.Review;
import com.saihou.jishop.entity.User;
import com.saihou.jishop.service.OrderService;
import com.saihou.jishop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商品評価
 *
 * @author saihou
 * @date 2021/04/27
 */
@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection"})
@Controller("shopReviewController")
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/review")
    public String review(Model model, Integer oid) {
        Order order = orderService.findById(oid);
        List<OrderItem> orderItems = order.getOrderItems();

        model.addAttribute("title", "評価");
        model.addAttribute("orderItems", orderItems);

        return "/shop/review/review";
    }

    @RequestMapping("/review.do")
    @ResponseBody
    public String doReview(HttpSession session, @RequestBody List<Review> reviews) {
        User user = (User) session.getAttribute("user");
        Integer oid = reviews.get(0).getOid();

        reviewService.insertReviews(reviews, user.getId());
        orderService.hasReviewed(oid);

        return "success";
    }
}
