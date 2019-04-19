package com.elect.dao.impl;

import com.elect.dao.AddressDao;
import com.elect.entity.Receive_address;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddressDaoImpl implements AddressDao {
    private static final String ADDADDRESS_SQL="insert into d_receive_address(user_id,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?)";
    @Override
    public void addAddress(Receive_address receive_address) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDADDRESS_SQL);
        ps.setInt(1,receive_address.getUser_id());
        ps.setString(2,receive_address.getReceive_name());
        ps.setString(3,receive_address.getFull_address());
        ps.setString(4,receive_address.getPostal_code());
        ps.setString(5,receive_address.getMobile());
        ps.setString(6,receive_address.getPhone());
        ps.executeUpdate();
        connection.close();
    }
}
