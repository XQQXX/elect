package com.elect.dao;

import com.elect.entity.Book;

import java.util.List;

public interface BookDao {
    /**
     * 查询所有book表信息
     * @return
     * @throws Exception
     */
    List<Book> findBookAll() throws Exception;
}
