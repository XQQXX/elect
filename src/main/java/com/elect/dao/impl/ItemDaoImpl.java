package com.elect.dao.impl;

import com.elect.dao.ItemDao;
import com.elect.entity.Item;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    private static final String ADDITEM_SQL="insert into d_item(order_id,product_id,product_name,dang_price,product_num,amount) values(?,?,?,?,?,?)";
    private static final String FINDBYORDERID_SQL="select * from d_item where order_id=?";
    @Override
    public void addItem(Item item) throws Exception {
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADDITEM_SQL);
        ps.setInt(1,item.getOrder_id());
        ps.setInt(2,item.getProduct_id());
        ps.setString(3,item.getProduct_name());
        ps.setDouble(4,item.getDang_price());
        ps.setInt(5,item.getProduct_num());
        ps.setDouble(6,item.getAmount());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public List<Item> findByOrderId(int order_id) throws Exception {
        List<Item> items=new ArrayList<>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYORDERID_SQL);
        ps.setInt(1,order_id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Item item=new Item(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getDouble(7));
            items.add(item);
        }
        connection.close();
        return items;
    }
}
