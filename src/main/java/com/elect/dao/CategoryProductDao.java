package com.elect.dao;

import com.elect.entity.Category_product;

import java.util.List;

public interface CategoryProductDao {

    List<Category_product> findByCatId(int id) throws Exception;

    /**
     * 根据product_id删除信息
     * @param id
     * @throws Exception
     */
    void deleteByProductId(int id) throws Exception;

    void update(Category_product category_product,int cat_id) throws Exception;

    List<Category_product> findByProductId(int product_id) throws Exception;

    void add(int book_id, int i) throws Exception;
}
