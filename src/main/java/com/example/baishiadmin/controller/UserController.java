package com.example.baishiadmin.controller;

import com.example.baishiadmin.common.Result;
import com.example.baishiadmin.entity.User;
import com.example.baishiadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result<List<User>> getAllUsers() {
        try {
            List<User> users = userService.findAll();
            return Result.success(users);
        } catch (Exception e) {
            return Result.error("获取用户列表失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            if (user != null) {
                return Result.success(user);
            } else {
                return Result.error("用户不存在");
            }
        } catch (Exception e) {
            return Result.error("获取用户信息失败：" + e.getMessage());
        }
    }

    @PostMapping
    public Result<User> createUser(@RequestBody User user) {
        try {
            User savedUser = userService.save(user);
            return Result.success(savedUser);
        } catch (Exception e) {
            return Result.error("创建用户失败：" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Result<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            user.setId(id);
            User updatedUser = userService.update(user);
            return Result.success(updatedUser);
        } catch (Exception e) {
            return Result.error("更新用户失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error("删除用户失败：" + e.getMessage());
        }
    }
}