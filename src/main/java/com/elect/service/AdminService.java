package com.elect.service;

import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Category_product;
import com.elect.entity.Product;

import java.util.List;

public interface AdminService {

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     * @throws Exception
     */
    boolean login(String name, String password) throws Exception;

    /**
     * 查询分类
     * @param id
     * @return
     */
    Category preEdit(int id) throws Exception;

    /**
     *修改分类
     * @param category
     * @throws Exception
     */
    void updateCate(Category category) throws Exception;

    /**
     * 删除分类
     * @param id
     * @throws Exception
     */
    void deleteCate(int id,int parent_id) throws Exception;

    /**
     * 添加分类
     * @param category
     * @throws Exception
     */
    void addCate(Category category) throws Exception;

    /**
     * 显示二级分类
     * @param id
     * @return
     * @throws Exception
     */
    List<Category> findCate(int id) throws Exception;

    /**
     * 删除图书所有
     * @param id
     * @throws Exception
     */
    void deleteBook(int id) throws Exception;

    /**
     * 修改图书信息
     * @param category_product
     * @param product_name
     * @param author
     * @param fixed_price
     * @throws Exception
     */
    void updateBook(Category_product category_product, String product_name, String author, Double fixed_price,int parent_id) throws Exception;

    /**
     * 查该图书分类
     * @param id
     * @return
     * @throws Exception
     */
    List<String> findCates(int id) throws Exception;

    /**
     * 添加图书
     * @param book
     * @param product
     * @param parent_id
     * @param cat_id
     */
    void addBook(Book book, Product product, int parent_id, int cat_id) throws Exception;
}
