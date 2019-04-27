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

    /**
     * 通过id查询分类信息
     * @param id
     * @return
     * @throws Exception
     */
    Category findById(int id) throws Exception;

    /**
     * 修改分类信息
     * @param category
     * @throws Exception
     */
    void updateById(Category category) throws Exception;

    /**
     * 根据id删除分类
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 根据parent_id删除分类
     * @param parent_id
     * @throws Exception
     */
    void deleteByParentId(int parent_id) throws Exception;

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category) throws Exception;
}
