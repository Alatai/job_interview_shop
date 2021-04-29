package com.saihou.service.impl;

import com.saihou.entity.User;
import com.saihou.mapper.UserMapper;
import com.saihou.query.UserQuery;
import com.saihou.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
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
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
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

    @Override
    public boolean isExist(String name) {
        User user = userMapper.findByName(name);

        return user != null;
    }

    @Override
    public User findByCondition(String name, String password) {
        UserQuery query = new UserQuery();
        query.setName(name);
        query.setPassword(password);

        return userMapper.findByCondition(query);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void register(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithm = "md5";

        String encodedPassword = new SimpleHash(algorithm, user.getPassword(), salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);

        insert(user);
    }
}
