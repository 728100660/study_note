package com.pxz.pojo;

import java.util.Date;

public class TeamRegister {
    private int id;
    private Date createDate;
    private int createBy;
    private String location;
    private String belongTo;
    private int leader;
    private String introduce;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return "TeamRegister{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", location='" + location + '\'' +
                ", belongTo='" + belongTo + '\'' +
                ", leader=" + leader +
                ", introduce='" + introduce + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
