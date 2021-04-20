package com.saihou.service;

import com.saihou.entity.User;

import java.util.List;

/**
 * ユーザ
 *
 * @author saihou
 * @date 2021/04/20
 */
public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}
