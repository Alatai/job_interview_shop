package com.saihou.jishop.service;

import com.saihou.jishop.entity.User;

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

    boolean isExist(String name);

    /**
     * ユーザネームとパスワードを基に、ユーザを検索する
     */
    User findByCondition(String name, String password);

    User findByName(String name);

    void register(User user);
}
