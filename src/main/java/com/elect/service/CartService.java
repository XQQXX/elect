package com.elect.service;

import com.elect.entity.Cart;
import com.elect.entity.Product;

import java.util.List;

public interface CartService {

    /**
     * 购物车添加商品
     * @param id
     * @throws Exception
     */
    void addCartBook(int id,int user_id) throws Exception;

    /**
     * 展示购物车
     * @param i
     * @return
     */
    List<Cart> showCart(int i,int user_id) throws Exception;

    /**
     * 改变商品状态
     * @param id
     */
    void changeStatus(int id,int status) throws Exception;

    /**
     * 改变商品数量
     * @param product_id
     * @param product_num
     * @throws Exception
     */
    void changeNum(int product_id, int product_num) throws Exception;

    /**
     * 下单成功删除购物车内容
     * @param user_id
     * @throws Exception
     */
    void delCart(int user_id,int status) throws Exception;
}
