package com.elect.dao.impl;

import com.elect.dao.OrderDao;
import com.elect.entity.Order;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDaoImpl implements OrderDao {

    private static final String ADDORDER_SQL="insert into d_order(user_id,order_time,total_price,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?,?,?)";
    private static final String FINDORDERID_SQL="select LAST_INSERT_ID()";
    private static final String FINDBYORDERID_SQL="select * from d_order where id=?";
    @Override
    public int addOrder(Order order) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDORDER_SQL);
        ps.setInt(1,order.getUser_id());
        ps.setString(2,order.getOrder_time());
        ps.setDouble(3,order.getTotal_price());
        ps.setString(4,order.getReceive_name());
        ps.setString(5,order.getFull_address());
        ps.setString(6,order.getPostal_code());
        ps.setString(7,order.getMobile());
        ps.setString(8,order.getPhone());
        ps.executeUpdate();
        ps=connection.prepareStatement(FINDORDERID_SQL);
        ResultSet rs=ps.executeQuery();
        int order_id=0;
        if(rs.next()){
            order_id=rs.getInt(1);
        }
        connection.close();
        return order_id;
    }

    @Override
    public Order findByOrderId(int order_id) throws Exception {
        Order order=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYORDERID_SQL);
        ps.setInt(1,order_id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            order=new Order(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
        }
        connection.close();
        return order;
    }
}
