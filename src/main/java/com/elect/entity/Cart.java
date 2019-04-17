package com.elect.entity;

import java.io.Serializable;

public class Cart implements Serializable {
    private int id;
    private int user_id;
    private int product_id;
    private String product_name;
    private double fixed_price;
    private double dang_price;
    private int product_num;
    private int status;

    public Cart() {
    }

    public Cart(int id, int user_id, int product_id, String product_name, double fixed_price, double dang_price, int product_num, int status) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.fixed_price = fixed_price;
        this.dang_price = dang_price;
        this.product_num = product_num;
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(double fixed_price) {
        this.fixed_price = fixed_price;
    }

    public double getDang_price() {
        return dang_price;
    }

    public void setDang_price(double dang_price) {
        this.dang_price = dang_price;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (id != cart.id) return false;
        if (user_id != cart.user_id) return false;
        if (product_id != cart.product_id) return false;
        if (Double.compare(cart.fixed_price, fixed_price) != 0) return false;
        if (Double.compare(cart.dang_price, dang_price) != 0) return false;
        if (product_num != cart.product_num) return false;
        if (status != cart.status) return false;
        return product_name != null ? product_name.equals(cart.product_name) : cart.product_name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + user_id;
        result = 31 * result + product_id;
        result = 31 * result + (product_name != null ? product_name.hashCode() : 0);
        temp = Double.doubleToLongBits(fixed_price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dang_price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + product_num;
        result = 31 * result + status;
        return result;
    }
}
