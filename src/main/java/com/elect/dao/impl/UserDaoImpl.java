package com.elect.dao.impl;

import com.elect.dao.UserDao;
import com.elect.entity.User;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static final String FINDBYEMAIL_SQL="select * from d_user where email=?";
    private static final String ADDUSER_SQL="insert into d_user(email,nickname,password,email_verify_code) values(?,?,?,?)";
    private static final String UPDATEUSER_SQL="update d_user set is_email_verify=?,last_login_time=?,last_login_ip=?,email_verify_code=? where email=?";
    private static final String SELECTUSER_SQL="select * from d_user where email=? and password=?";
    @Override
    public User findByEmail(String email) throws SQLException {
        Connection connection= DBUtil.getConnection();
        User user = null;
        PreparedStatement ps=connection.prepareStatement(FINDBYEMAIL_SQL);
        ps.setString(1,email);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user=new User(rs.getInt("id"),email,rs.getString("nickname"),rs.getString("password"),rs.getInt("user_integral"),rs.getString("is_email_verify"),rs.getString("email_verify_code"),rs.getString("last_login_time"),rs.getString("last_login_ip"));
        }
        connection.close();
        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDUSER_SQL);
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getNickname());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getEmail_verify_code());
        ps.execute();
        connection.close();
    }

    @Override
    public void updateUser(User user) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UPDATEUSER_SQL);
        ps.setString(1,user.getIs_email_verify());
        ps.setString(2,user.getLast_login_time());
        ps.setString(3,user.getLast_login_ip());
        ps.setString(4,user.getEmail_verify_code());
        ps.setString(5,user.getEmail());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public User findUser(User u) throws Exception {
        User user=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(SELECTUSER_SQL);
        ps.setString(1,u.getEmail());
        ps.setString(2,u.getPassword());
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user=new User(rs.getInt("id"),rs.getString("email"),rs.getString("nickname"),rs.getString("password"),rs.getInt("user_integral"),rs.getString("is_email_verify"),rs.getString("email_verify_code"),rs.getString("last_login_time"),rs.getString("last_login_ip"));
        }
        connection.close();
        return user;
    }
}
