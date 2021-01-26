package com.pxz.pojo;

import java.util.Date;

public class User {
    private int id;
    private String phoneNumber;
    private String email;
    private String account;
    private String password;
    private String userName;
    private boolean role;
    private int teamId;
    private Date registerDate;
    private Date lastLoginDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getteamId() {
        return teamId;
    }

    public void setteamId(int teamId) {
        this.teamId = teamId;
    }

    public Date getregisterDate() {
        return registerDate;
    }

    public void setregisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getlastLoginDate() {
        return lastLoginDate;
    }

    public void setlastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                ", teamId=" + teamId +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
