package com.saihou.service;

import com.saihou.entity.Review;

import java.util.List;

/**
 * 商品コメント
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
}
