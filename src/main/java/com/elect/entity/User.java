package com.elect.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String email;
    private String nickname;
    private String password;
    private int user_integral;
    private String is_email_verify;
    private String email_verify_code;
    private String last_login_time;
    private String last_login_ip;

    public User() {
    }

    public User(String email, String nickname, String password, String email_verify_code) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.email_verify_code = email_verify_code;
    }

    public User(int id, String email, String nickname, String password, int user_integral, String is_email_verify, String email_verify_code, String last_login_time, String last_login_ip) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.user_integral = user_integral;
        this.is_email_verify = is_email_verify;
        this.email_verify_code = email_verify_code;
        this.last_login_time = last_login_time;
        this.last_login_ip = last_login_ip;
    }

    public String getEmail_verify_code() {
        return email_verify_code;
    }

    public void setEmail_verify_code(String email_verify_code) {
        this.email_verify_code = email_verify_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(int user_integral) {
        this.user_integral = user_integral;
    }

    public String getIs_email_verify() {
        return is_email_verify;
    }

    public void setIs_email_verify(String is_email_verify) {
        this.is_email_verify = is_email_verify;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", user_integral=" + user_integral +
                ", is_email_verify='" + is_email_verify + '\'' +
                ", last_login_time=" + last_login_time +
                ", last_login_ip='" + last_login_ip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (user_integral != user.user_integral) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (is_email_verify != null ? !is_email_verify.equals(user.is_email_verify) : user.is_email_verify != null)
            return false;
        if (email_verify_code != null ? !email_verify_code.equals(user.email_verify_code) : user.email_verify_code != null)
            return false;
        if (last_login_time != null ? !last_login_time.equals(user.last_login_time) : user.last_login_time != null)
            return false;
        return last_login_ip != null ? last_login_ip.equals(user.last_login_ip) : user.last_login_ip == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + user_integral;
        result = 31 * result + (is_email_verify != null ? is_email_verify.hashCode() : 0);
        result = 31 * result + (email_verify_code != null ? email_verify_code.hashCode() : 0);
        result = 31 * result + (last_login_time != null ? last_login_time.hashCode() : 0);
        result = 31 * result + (last_login_ip != null ? last_login_ip.hashCode() : 0);
        return result;
    }
}
