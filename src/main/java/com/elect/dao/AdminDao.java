package com.elect.dao;

import com.elect.entity.Admin;

public interface AdminDao {
    /**
     * 通过用户名密码查找管理员
     * @param name
     * @param password
     * @return
     */
    Admin findByNameAndPassword(String name, String password) throws Exception;
}
