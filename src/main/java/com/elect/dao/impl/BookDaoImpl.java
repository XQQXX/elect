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
    private static final String DELETEBYID_SQL="delete from d_book where id=?";
    private static final String UPDATE_SQL="update d_book set author=? where id=?";
    private static final String ADD_SQL="insert into d_book(author,publishing,publish_time,word_number,which_edtion,total_page,isbn,author_summary,catalogue) values(?,?,?,?,?,?,?,?,?)";
    private static final String FINDID_SQL="select LAST_INSERT_ID()";
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

    @Override
    public void deleteById(int id) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(DELETEBYID_SQL);
        ps.setInt(1,id);
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int product_id, String author) throws Exception {
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(UPDATE_SQL);
        ps.setString(1,author);
        ps.setInt(2,product_id);
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public int add(Book book) throws Exception {
        int book_id=0;
        Connection connection=DBUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(ADD_SQL);
        ps.setString(1,book.getAuthor());
        ps.setString(2,book.getPublishing());
        ps.setDouble(3,book.getPublish_time());
        ps.setString(4,book.getWord_number());
        ps.setString(5,book.getWhich_edtion());
        ps.setString(6,book.getTotal_page());
        ps.setString(7,book.getIsbn());
        ps.setString(8,book.getAuthor_summary());
        ps.setString(9,book.getCatalogue());
        ps.executeUpdate();
        ps=connection.prepareStatement(FINDID_SQL);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            book_id = rs.getInt(1);
        }
        connection.close();
        return book_id;
    }

}
