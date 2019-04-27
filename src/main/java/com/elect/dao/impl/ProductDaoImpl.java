package com.elect.dao.impl;

import com.elect.dao.ProductDao;
import com.elect.entity.Product;
import com.elect.util.DBUtil;
import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String FINDALL_SQL="select * from d_product";
    private static final String FINDBYID_SQL="select * from d_product where id=?";
    private static final String DELETEBYID_SQL="delete from d_product where id=?";
    private static final String UPDATE_SQL="update d_product set product_name=?,fixed_price=? where id=?";
    private static final String ADD_SQL="insert into d_product(id,product_name,description,add_time,fixed_price,dang_price,product_pic) values(?,?,?,?,?,?,?)";
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

    @Override
    public void deleteById(int id) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(DELETEBYID_SQL);
        ps.setInt(1,id);
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int product_id, String product_name, Double fixed_price) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UPDATE_SQL);
        ps.setString(1,product_name);
        ps.setDouble(2,fixed_price);
        ps.setInt(3,product_id);
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void add(Product product) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADD_SQL);
        ps.setInt(1,product.getId());
        ps.setString(2,product.getProduct_name());
        ps.setString(3,product.getDescription());
        ps.setDouble(4,product.getAdd_time());
        ps.setDouble(5,product.getFixed_price());
        ps.setDouble(6,product.getDang_price());
        ps.setString(7,product.getProduct_pic());
        ps.executeUpdate();
        connection.close();
    }


}
