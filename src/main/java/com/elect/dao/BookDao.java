package com.elect.dao;

import com.elect.entity.Book;
import com.elect.entity.Category_product;

import java.util.List;

public interface BookDao {
    /**
     * 查询所有book表信息
     * @return
     * @throws Exception
     */
    List<Book> findBookAll() throws Exception;

    /**
     * 根据Id查book
     * @param id
     * @return
     * @throws Exception
     */
    Book findBookById(int id) throws Exception;
}
