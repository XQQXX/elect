package com.elect.entity;

import java.io.Serializable;

public class Category_product implements Serializable {
    private int id;
    private int product_id;
    private int cat_id;

    public Category_product() {
    }

    public Category_product(int id, int product_id, int cat_id) {
        this.id = id;
        this.product_id = product_id;
        this.cat_id = cat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "Category_product{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", cat_id=" + cat_id +
                '}';
    }
}
