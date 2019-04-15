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
}
