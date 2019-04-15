package com.elect.dao;

import com.elect.entity.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 通过parentId查询分类
     * @param i
     * @return
     * @throws Exception
     */
    List<Category> findByParentId(int i) throws Exception;
}
