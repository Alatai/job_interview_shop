package com.saihou.service.impl;

import com.saihou.entity.User;
import com.saihou.mapper.UserMapper;
import com.saihou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザ
 *
 * @author saihou
 * @date 2021/04/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
