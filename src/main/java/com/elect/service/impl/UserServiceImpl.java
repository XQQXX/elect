package com.elect.service.impl;

import com.elect.dao.UserDao;
import com.elect.dao.impl.UserDaoImpl;
import com.elect.entity.User;
import com.elect.factory.DaoFactory;
import com.elect.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao= (UserDao) DaoFactory.getDaoImpl("UserDao");
    @Override
    public boolean checkEmail(String email) throws Exception {
        return userDao.findByEmail(email)==null;
    }

    @Override
    public boolean checkCode(String code, String verifyCode) throws Exception{
        return code.equalsIgnoreCase(verifyCode);
    }

    @Override
    public void RegistUser(User user) throws Exception{
        userDao.addUser(user);
    }

    @Override
    public boolean checkEmailCode(String uuid,String emailCode) throws Exception {
        return uuid.equals(emailCode);
    }

    @Override
    public void RegistUserDetil(User user) throws Exception {
        userDao.updateUser(user);
    }


    @Override
    public User checkLogin(User u) throws Exception {
        User user=userDao.findUser(u);
        return user;
    }
}
