package com.elect.dao;

import com.elect.entity.Cart;
import com.elect.entity.Product;

import java.util.List;

public interface CartDao {

    /**
     * 添加商品进购物车
     * @throws Exception
     */
    void addCart(Product product,int user_id) throws Exception;

    /**
     * 根据状态查询购物车
     * @param i
     * @return
     * @throws Exception
     */
    List<Cart> findByStatus(int i,int user_id) throws Exception;

    /**
     * 根据product_id查询cart
     * @param id
     * @return
     */
    Cart findByProductId(int id) throws Exception;

    /**
     * 改变status
     * @param id
     */
    void updateStatus(int id,int status) throws Exception;

    /**
     * 改变product_num
     * @param product_id
     * @param product_num
     */
    void updateNum(int product_id, int product_num) throws Exception;
}
