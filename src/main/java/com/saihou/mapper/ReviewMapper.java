package com.saihou.mapper;

import com.saihou.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 商品評価
 */
@Repository("reviewMapper")
public interface ReviewMapper {

    List<Review> findByPid(Integer pid);

    Review findById(Integer id);

    int insert(Review review);

    int update(Review review);

    int delete(Integer id);
}