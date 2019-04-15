package com.elect.dao.impl;

import com.elect.dao.CategoryDao;
import com.elect.entity.Category;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static final String FINDBYPARENTID_SQL="select * from d_category where parent_id=?";

    @Override
    public List<Category> findByParentId(int i) throws Exception {
        List<Category> list=new ArrayList<>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYPARENTID_SQL);
        ps.setInt(1,i);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Category category=new Category(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),i);
            list.add(category);
        }
        connection.close();
        return list;
    }
}
