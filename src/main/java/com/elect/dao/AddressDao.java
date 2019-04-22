package com.elect.dao;

import com.elect.entity.Receive_address;

import java.util.List;

public interface AddressDao {
    /**
     * 添加地址信息
     * @param receive_address
     * @throws Exception
     */
    void addAddress(Receive_address receive_address) throws Exception;

    /**
     * 根据用户id查询用户所有地址
     * @param user_id
     * @return
     * @throws Exception
     */
    List<Receive_address> findByUserId(int user_id) throws Exception;

    /**
     * 根据地址id查询用户地址
     * @param id
     * @return
     * @throws Exception
     */
    Receive_address findById(int id) throws Exception;
}
