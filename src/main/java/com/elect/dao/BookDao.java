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

    /**
     * 根据id删除图书
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 更新图书信息
     * @param product_id
     * @param author
     */
    void update(int product_id, String author) throws Exception;

    /**
     * 添加图书
     * @param book
     * @throws Exception
     */
    int add(Book book) throws Exception;
}
