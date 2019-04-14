package com.elect.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String product_name;
    private String description;
    private long add_time;
    private Double fixed_price;
    private Double dang_price;
    private String keywords;
    private int has_seleted;
    private String product_pic;

    public Product() {
    }

    public Product(int id, String product_name, String description, long add_time, Double fixed_price, Double dang_price, String keywords, int has_seleted, String product_pic) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.add_time = add_time;
        this.fixed_price = fixed_price;
        this.dang_price = dang_price;
        this.keywords = keywords;
        this.has_seleted = has_seleted;
        this.product_pic = product_pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public Double getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(Double fixed_price) {
        this.fixed_price = fixed_price;
    }

    public Double getDang_price() {
        return dang_price;
    }

    public void setDang_price(Double dang_price) {
        this.dang_price = dang_price;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getHas_seleted() {
        return has_seleted;
    }

    public void setHas_seleted(int has_seleted) {
        this.has_seleted = has_seleted;
    }

    public String getProduct_pic() {
        return product_pic;
    }

    public void setProduct_pic(String product_pic) {
        this.product_pic = product_pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (add_time != product.add_time) return false;
        if (has_seleted != product.has_seleted) return false;
        if (product_name != null ? !product_name.equals(product.product_name) : product.product_name != null)
            return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (fixed_price != null ? !fixed_price.equals(product.fixed_price) : product.fixed_price != null) return false;
        if (dang_price != null ? !dang_price.equals(product.dang_price) : product.dang_price != null) return false;
        if (keywords != null ? !keywords.equals(product.keywords) : product.keywords != null) return false;
        return product_pic != null ? product_pic.equals(product.product_pic) : product.product_pic == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (product_name != null ? product_name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (add_time ^ (add_time >>> 32));
        result = 31 * result + (fixed_price != null ? fixed_price.hashCode() : 0);
        result = 31 * result + (dang_price != null ? dang_price.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + has_seleted;
        result = 31 * result + (product_pic != null ? product_pic.hashCode() : 0);
        return result;
    }
}
