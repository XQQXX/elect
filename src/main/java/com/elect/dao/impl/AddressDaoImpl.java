package com.elect.dao.impl;

import com.elect.dao.AddressDao;
import com.elect.entity.Receive_address;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private static final String ADDADDRESS_SQL="insert into d_receive_address(user_id,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?)";
    private static final String FINDBYUSERID_SQL="select * from d_receive_address where user_id=?";
    private static final String FINDBYID_SQL="select * from d_receive_address where id=?";

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

    @Override
    public List<Receive_address> findByUserId(int user_id) throws Exception {
        List<Receive_address> list=new ArrayList<>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYUSERID_SQL);
        ps.setInt(1,user_id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Receive_address receive_address=new Receive_address(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            list.add(receive_address);
        }
        connection.close();
        return list;
    }

    @Override
    public Receive_address findById(int id) throws Exception {
        Receive_address receive_address=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            receive_address=new Receive_address(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        }
        connection.close();
        return receive_address;
    }
}
