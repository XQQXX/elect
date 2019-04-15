package com.elect.dao.impl;

import com.elect.dao.ProductDao;
import com.elect.entity.Product;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String FINDALL_SQL="select * from d_product";
    private static final String FINDBYID_SQL="select * from d_product where id=?";
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> products=new ArrayList<Product>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDALL_SQL);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Product product=new Product(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getLong(4),rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getInt(8), rs.getString(9));
            products.add(product);
        }
        connection.close();
        return products;
    }

    @Override
    public Product findById(int id) throws Exception {
        Product product=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            product=new Product(id, rs.getString(2),rs.getString(3),rs.getLong(4),rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getInt(8), rs.getString(9));
        }
        connection.close();
        return product;
    }


}
