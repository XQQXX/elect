package com.elect.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private int user_id;
    private int status;
    private String order_time;
    private String order_desc;
    private Double total_price;
    private String receive_name;
    private String full_address;
    private String postal_code;
    private String mobile;
    private String phone;

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Order() {
    }

    public Order(int id, int user_id, int status, String order_time, String order_desc, Double total_price, String receive_name, String full_address, String postal_code, String mobile, String phone) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.order_time = order_time;
        this.order_desc = order_desc;
        this.total_price = total_price;
        this.receive_name = receive_name;
        this.full_address = full_address;
        this.postal_code = postal_code;
        this.mobile = mobile;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", order_time='" + order_time + '\'' +
                ", order_desc='" + order_desc + '\'' +
                ", total_price=" + total_price +
                ", receive_name='" + receive_name + '\'' +
                ", full_address='" + full_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", items=" + items +
                '}';
    }
}
