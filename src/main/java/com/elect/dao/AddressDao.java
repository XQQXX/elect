package com.elect.dao;

import com.elect.entity.Receive_address;

public interface AddressDao {
    /**
     * 添加地址信息
     * @param receive_address
     * @throws Exception
     */
    void addAddress(Receive_address receive_address) throws Exception;
}
