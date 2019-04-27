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
    private static final String FINDBYID_SQL="select * from d_category where id=?";
    private static final String UODATEBYID_SQL="update d_category set name=? where id=?";
    private static final String DELETEBYID_SQL="delete from d_category where id=?";
    private static final String DELETEBYPARENTID_SQL="delete from d_category where parent_id=?";
    private static final String ADDCATEGORY_SQL="insert into d_category(en_name,name,parent_id) values(?,?,?)";
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

    @Override
    public Category findById(int id) throws Exception {
        Category category=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            category=new Category(id,rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
        }
        connection.close();
        return category;
    }

    @Override
    public void updateById(Category category) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UODATEBYID_SQL);
        ps.setString(1,category.getName());
        ps.setInt(2,category.getId());
        ps.executeUpdate();
        connection.close();
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
    public void deleteByParentId(int parent_id) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(DELETEBYPARENTID_SQL);
        ps.setInt(1,parent_id);
        ps.execute();
        connection.close();
    }

    @Override
    public void addCategory(Category category) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDCATEGORY_SQL);
        ps.setString(1,category.getEn_name());
        ps.setString(2,category.getName());
        ps.setInt(3,category.getParent_id());
        ps.executeUpdate();
    }
}
