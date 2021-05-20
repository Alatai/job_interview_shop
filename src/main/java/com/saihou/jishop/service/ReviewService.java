package com.saihou.jishop.service;

import com.saihou.jishop.entity.Review;

import java.util.List;

/**
 * 商品評価
 *
 * @author saihou
 * @date 2021/04/23
 */
public interface ReviewService {

    List<Review> findByPid(Integer pid);

    Review findById(Integer id);

    int insert(Review review);

    int update(Review review);

    int delete(Integer id);

    void insertReviews(List<Review> reviews, Integer uid);

    int getReviewCount(Integer pid);
}
