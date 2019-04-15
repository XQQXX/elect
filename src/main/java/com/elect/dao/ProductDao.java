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

    Product findById(int id) throws Exception;
}
