package com.elect.entity;

import java.io.Serializable;

public class Receive_address implements Serializable {
    private int id;
    private int user_id;
    private String receive_name;
    private String full_address;
    private String postal_code;
    private String mobile;
    private String phone;

    public Receive_address() {
    }

    public Receive_address(int user_id, String receive_name, String full_address, String postal_code, String mobile, String phone) {
        this.user_id = user_id;
        this.receive_name = receive_name;
        this.full_address = full_address;
        this.postal_code = postal_code;
        this.mobile = mobile;
        this.phone = phone;
    }

    public Receive_address(int id, int user_id, String receive_name, String full_address, String postal_code, String mobile, String phone) {
        this.id = id;
        this.user_id = user_id;
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
        return "Receive_address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", receive_name='" + receive_name + '\'' +
                ", full_address='" + full_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receive_address that = (Receive_address) o;

        if (user_id != that.user_id) return false;
        if (receive_name != null ? !receive_name.equals(that.receive_name) : that.receive_name != null) return false;
        if (full_address != null ? !full_address.equals(that.full_address) : that.full_address != null) return false;
        if (postal_code != null ? !postal_code.equals(that.postal_code) : that.postal_code != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;

    }

    @Override
    public int hashCode() {
        int result = user_id;
        result = 31 * result + (receive_name != null ? receive_name.hashCode() : 0);
        result = 31 * result + (full_address != null ? full_address.hashCode() : 0);
        result = 31 * result + (postal_code != null ? postal_code.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
