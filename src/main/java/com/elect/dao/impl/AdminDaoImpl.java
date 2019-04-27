package com.elect.dao.impl;

import com.elect.dao.AdminDao;
import com.elect.entity.Admin;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoImpl implements AdminDao {
    private static final String FINDBYNAMEANDPASSWORD="select * from d_admin where name=? and password=?";
    @Override
    public Admin findByNameAndPassword(String name, String password) throws Exception {
        Admin admin=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYNAMEANDPASSWORD);
        ps.setString(1,name);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            admin=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        return admin;
    }
}
