package com.example.baishiadmin.mapper;

import com.example.baishiadmin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户记录
     * 
     * @return 返回一个包含所有用户记录的List<User>，如果没有记录则返回空列表
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return 返回一个User对象，如果没有找到则返回null
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Long id);

    /**
     * 根据用户名查询用户信息
     * 
     * @param username 用户名
     * @return 返回一个User对象，如果没有找到则返回null
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    /**
     * 根据邮箱查询用户信息
     * 
     * @param email 用户邮箱
     * @return 返回一个User对象，如果没有找到则返回null
     */
    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(String email);

    /**
     * 插入新用户记录到数据库
     *
     * @param user 包含新用户信息的User对象
     * @return 返回插入操作影响的行数，通常为1表示插入成功
     */
    @Insert("INSERT INTO user (username, password, email, created_at, updated_at) " +
            "VALUES (#{username}, #{password}, #{email}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    /**
     * 更新用户信息
     * 
     * @param user 包含更新后用户信息的User对象
     * @return 返回更新操作影响的行数，通常为1表示更新成功
     */
    @Update("UPDATE user SET username = #{username}, password = #{password}, " +
            "email = #{email}, updated_at = NOW() WHERE id = #{id}")
    int update(User user);

    /**
     * 根据用户ID删除用户记录
     * 
     * @param id 要删除的用户的ID
     * @return 返回删除操作影响的行数，通常为1表示删除成功
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Long id);
}
