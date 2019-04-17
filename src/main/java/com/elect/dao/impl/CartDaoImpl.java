package com.elect.dao.impl;

import com.elect.dao.CartDao;
import com.elect.entity.Cart;
import com.elect.entity.Product;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private static final String ADDCART_SQL="insert into d_cart(user_id,product_id,product_name,fixed_price,dang_price) values(?,?,?,?,?)";
    private static final String FINDBYSTATUS_SQL="select * from d_cart where status=? and user_id=?";
    private static final String FINDBYPRODUCTID_SQL="select * from d_cart where product_id=?";
    private static final String UPDATESTATUS_SQL="update d_cart set product_num=1,status=? where product_id=?";
    private static final String UPDATEPRODUVTNUM_SQL="update d_cart set product_num=? where product_id=?";
    @Override
    public void addCart(Product product,int user_id) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDCART_SQL);
        ps.setInt(1,user_id);
        ps.setInt(2,product.getId());
        ps.setString(3,product.getProduct_name());
        ps.setDouble(4,product.getFixed_price());
        ps.setDouble(5,product.getDang_price());
        ps.execute();
        connection.close();
    }

    @Override
    public List<Cart> findByStatus(int i,int user_id) throws Exception {
        List<Cart> list=new ArrayList<>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYSTATUS_SQL);
        ps.setInt(1,i);
        ps.setInt(2,user_id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Cart cart=new Cart(rs.getInt(1),user_id,rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),i);
            list.add(cart);
        }
        connection.close();
        return list;
    }

    @Override
    public Cart findByProductId(int id) throws Exception {
        Cart cart=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYPRODUCTID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            cart=new Cart(rs.getInt(1),rs.getInt(2),id,rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8));
        }
        connection.close();
        return cart;
    }

    @Override
    public void updateStatus(int id,int status) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UPDATESTATUS_SQL);
        ps.setInt(2,id);
        ps.setInt(1,status);
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void updateNum(int product_id, int product_num) throws Exception{
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UPDATEPRODUVTNUM_SQL);
        ps.setInt(1,product_num);
        ps.setInt(2,product_id);
        ps.executeUpdate();
        connection.close();
    }
}
