package com.saihou.jishop.mapper;

import com.saihou.jishop.entity.User;
import com.saihou.jishop.query.UserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ユーザ
 */
@Repository("userMapper")
public interface UserMapper {

    List<User> findAll();

    User findByName(String name);

    User findById(Integer id);

    int insert(User user);

    int update(User user);

    int delete(Integer id);

    User findByCondition(UserQuery query);
}