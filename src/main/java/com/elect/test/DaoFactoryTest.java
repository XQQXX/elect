package com.elect.test;

import com.elect.dao.UserDao;
import com.elect.factory.DaoFactory;
import org.junit.Test;

public class DaoFactoryTest {

    @Test
    public void test(){
        UserDao userDao= (UserDao) DaoFactory.getDaoImpl("UserDao");
        System.out.println(userDao);
    }
}
