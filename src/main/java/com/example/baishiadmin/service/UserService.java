package com.example.baishiadmin.service;

import com.example.baishiadmin.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
}