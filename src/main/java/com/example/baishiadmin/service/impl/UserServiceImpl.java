package com.example.baishiadmin.service.impl;

import com.example.baishiadmin.mapper.UserMapper;
import com.example.baishiadmin.entity.User;
import com.example.baishiadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        // 调用UserMapper的findById方法，根据id查询用户信息
        // 并将查询结果返回
        return userMapper.findById(id);
    }

    @Override
    public User save(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User update(User user) {
        userMapper.update(user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }
}