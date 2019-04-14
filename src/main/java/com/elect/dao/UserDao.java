package com.elect.dao;

import com.elect.entity.User;

import java.sql.SQLException;

public interface UserDao {
    /**
     * 通过Email查找用户
     * @param email
     * @return
     * @throws Exception
     */
    User findByEmail(String email) throws Exception;

    /**
     * 添加用户信息
     * @param user
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * 更新用户详细信息
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     * 查询用户是否存在
     * @param u
     * @return
     * @throws Exception
     */
    User findUser(User u) throws Exception;
}
