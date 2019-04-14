package com.elect.service;

import com.elect.entity.User;

public interface UserService {
    /**
     *验证邮箱是否存在
     * @param email
     * @return
     * @throws Exception
     */
    boolean checkEmail(String email)throws Exception;

    /**
     * 注册页面验证用户验证码是否正确
     * @param code
     * @param verifyCode
     * @return
     */
    boolean checkCode(String code, String verifyCode)throws Exception;

    /**
     * 用户注册1---基本信息
     * @param user
     */
    void RegistUser(User user)throws Exception;

    /**
     * 用户注册2---邮箱验证
     * @param emailCode
     * @return
     * @throws Exception
     */
    boolean checkEmailCode(String uuid,String emailCode)throws Exception;

    /**
     * 用户注册3---详细信息
     * @param user
     * @throws Exception
     */
    void RegistUserDetil(User user) throws Exception;


    /**
     * 查询用户
     * @param u
     * @return
     * @throws Exception
     */
    User checkLogin(User u) throws Exception;
}
