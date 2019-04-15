package com.elect.dao;

import com.elect.entity.Category_product;

import java.util.List;

public interface CategoryProductDao {

    List<Category_product> findByCatId(int id) throws Exception;
}
