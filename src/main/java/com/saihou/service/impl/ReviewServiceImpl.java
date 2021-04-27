package com.saihou.service.impl;

import com.saihou.entity.Review;
import com.saihou.mapper.ReviewMapper;
import com.saihou.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品評価
 *
 * @author saihou
 * @date 2021/04/23
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    @Qualifier("reviewMapper")
    private ReviewMapper reviewMapper;

    @Override
    public List<Review> findByPid(Integer pid) {
        return reviewMapper.findByPid(pid);
    }

    @Override
    public Review findById(Integer id) {
        return reviewMapper.findById(id);
    }

    @Override
    public int insert(Review review) {
        return reviewMapper.insert(review);
    }

    @Override
    public int update(Review review) {
        return reviewMapper.update(review);
    }

    @Override
    public int delete(Integer id) {
        return reviewMapper.delete(id);
    }
}
