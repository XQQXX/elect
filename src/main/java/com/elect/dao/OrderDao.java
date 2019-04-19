package com.elect.dao;

import com.elect.entity.Order;

public interface OrderDao {
    /**
     * 添加订单信息
     * @param order
     * @return
     * @throws Exception
     */
    int addOrder(Order order) throws Exception;

    /**
     * 通过订单号查询订单
     * @param order_id
     * @return
     * @throws Exception
     */
    Order findByOrderId(int order_id) throws Exception;
}
