package com.elect.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String name;
    private String password;
    private int admin_grade;

    public Admin() {
    }

    public Admin(int id, String name, String password, int admin_grade) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin_grade = admin_grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin_grade() {
        return admin_grade;
    }

    public void setAdmin_grade(int admin_grade) {
        this.admin_grade = admin_grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (id != admin.id) return false;
        if (admin_grade != admin.admin_grade) return false;
        if (name != null ? !name.equals(admin.name) : admin.name != null) return false;
        return password != null ? password.equals(admin.password) : admin.password == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + admin_grade;
        return result;
    }
}
