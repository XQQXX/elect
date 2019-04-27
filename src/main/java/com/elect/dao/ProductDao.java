package com.elect.dao;

import com.elect.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有product
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 根据id查product
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(int id) throws Exception;

    /**
     * 根据id删除图书
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 更新图书
     * @param product_id
     * @param product_name
     * @param fixed_price
     * @throws Exception
     */
    void update(int product_id, String product_name, Double fixed_price) throws Exception;

    /**
     * 添加图书
     * @param product
     * @throws Exception
     */
    void add(Product product) throws Exception;
}
