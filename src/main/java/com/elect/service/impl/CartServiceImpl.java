package com.elect.service.impl;

import com.elect.dao.CartDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Cart;
import com.elect.entity.Product;
import com.elect.factory.DaoFactory;
import com.elect.service.CartService;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    //注入dao对象
    private ProductDao productDao= (ProductDao) DaoFactory.getDaoImpl("ProductDao");
    private CartDao cartDao= (CartDao) DaoFactory.getDaoImpl("CartDao");

    @Override
    public void addCartBook(int id,int user_id) throws Exception {
        Cart cart=cartDao.findByProductId(id);
        if(cart==null) {
            Product product = productDao.findById(id);
            cartDao.addCart(product, user_id);
        }
    }

    @Override
    public List<Cart> showCart(int i,int user_id) throws Exception {
        List<Cart> list=cartDao.findByStatus(i,user_id);
        return list;
    }

    @Override
    public void changeStatus(int id,int status) throws Exception {
        cartDao.updateStatus(id,status);
    }

    @Override
    public void changeNum(int product_id, int product_num) throws Exception {
        cartDao.updateNum(product_id,product_num);
    }

    @Override
    public void delCart(int user_id,int status) throws Exception {
        cartDao.deleteCart(user_id,status);
    }


}
