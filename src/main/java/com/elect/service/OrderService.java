package com.elect.service;

import com.elect.entity.Cart;
import com.elect.entity.Order;
import com.elect.entity.Receive_address;

import java.util.List;

public interface OrderService {
    /**
     * 添加订单
     * @param carts
     * @return
     * @throws Exception
     */
    int addOrder(List<Cart> carts,Order order) throws Exception;

    /**
     * 添加订单商品
     * @param carts
     * @param order_id
     * @throws Exception
     */
    void addItem(List<Cart> carts, int order_id) throws Exception;

    /**
     * 查询订单
     * @param order_id
     * @return
     * @throws Exception
     */
    Order findOrder(int order_id) throws Exception;

    /**
     * 添加地址
     * @param receive_address
     * @throws Exception
     */
    void addAddress(Receive_address receive_address) throws Exception;
}
