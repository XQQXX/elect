package com.elect.dao.impl;

import com.elect.dao.CategoryProductDao;
import com.elect.entity.Category_product;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryProductDaoImpl implements CategoryProductDao {
    private static final String FINDBYID_SQL="select * from d_category_product where cat_id=?";
    private static final String DELETEPRODUCTID_SQL="delete from d_category_product where product_id=?";
    private static final String UPDATE_SQL="update d_category_product set cat_id=? where product_id=? and cat_id=?";
    private static final String FINDBYPRODUCTID_SQL="select * from d_category_product where product_id=?";
    private static final String ADD_SQL="insert into d_category_product(product_id,cat_id) values(?,?)";
    @Override
    public List<Category_product> findByCatId(int id) throws Exception {
        List<Category_product> list=new ArrayList<>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Category_product category_product=new Category_product(rs.getInt(1),rs.getInt(2),id);
            list.add(category_product);
        }
        connection.close();
        return list;
    }

    @Override
    public void deleteByProductId(int id) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(DELETEPRODUCTID_SQL);
        ps.setInt(1,id);
        ps.execute();
        connection.close();
    }

    @Override
    public void update(Category_product category_product,int cat_id) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps =connection.prepareStatement(UPDATE_SQL);
        ps.setInt(1,cat_id);
        ps.setInt(2,category_product.getProduct_id());
        ps.setInt(3,category_product.getCat_id());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public List<Category_product> findByProductId(int product_id) throws Exception {
        List<Category_product> list=new ArrayList<>();
        Category_product category_product=null;
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYPRODUCTID_SQL);
        ps.setInt(1,product_id);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            category_product=new Category_product(rs.getInt(1),product_id,rs.getInt(3));
            list.add(category_product);
        }
        connection.close();
        return list;
    }

    @Override
    public void add(int book_id, int i) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADD_SQL);
        ps.setInt(1,book_id);
        ps.setInt(2,i);
        ps.executeUpdate();
        connection.close();
    }
}
