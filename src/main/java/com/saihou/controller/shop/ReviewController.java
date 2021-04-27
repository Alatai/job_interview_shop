package com.saihou.controller.shop;

import com.saihou.service.OrderService;
import com.saihou.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

        model.addAttribute("title", "評価");

        return "/shop/review/review";
    }


    @RequestMapping("/review.do")
    public String doReview(Integer oid) {
        orderService.hasReviewed(oid);

        return "";
    }



}
