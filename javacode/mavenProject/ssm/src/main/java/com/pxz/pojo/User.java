package com.pxz.pojo;

import java.util.Date;

public class User {
    private int id;
    private String phone_number;
    private String email;
    private String account;
    private String password;
    private String user_name;
    private boolean role;
    private int team_id;
    private Date register_date;
    private Date last_login_dat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Date getLast_login_dat() {
        return last_login_dat;
    }

    public void setLast_login_dat(Date last_login_dat) {
        this.last_login_dat = last_login_dat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", role=" + role +
                ", team_id=" + team_id +
                ", register_date=" + register_date +
                ", last_login_dat=" + last_login_dat +
                '}';
    }
}
