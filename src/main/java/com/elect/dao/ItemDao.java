package com.elect.dao;

import com.elect.entity.Item;

import java.util.List;

public interface ItemDao {
    /**
     * 添加item
     * @param item
     * @throws Exception
     */
    void addItem(Item item) throws Exception;

    /**
     * 通过订单号查询订单内商品
     * @param order_id
     * @return
     * @throws Exception
     */
    List<Item> findByOrderId(int order_id) throws Exception;
}
