package com.elect.dao.impl;

import com.elect.dao.BookDao;
import com.elect.entity.Book;
import com.elect.entity.Category_product;
import com.elect.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final String FINDALL_SQL="select * from d_book";
    private static final String FINDBYID_SQL="select * from d_book where id=?";
    @Override
    public List<Book> findBookAll() throws Exception {
        List<Book> books=new ArrayList<Book>();
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDALL_SQL);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
            books.add(book);
        }
        connection.close();
        return books;
    }

    @Override
    public Book findBookById(int id) throws Exception {
        Book book=null;
        Connection connection= DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(FINDBYID_SQL);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            book=new Book(id,rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
        }
        connection.close();
        return book;
    }

}
