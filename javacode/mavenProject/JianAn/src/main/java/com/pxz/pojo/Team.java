package com.pxz.pojo;

import java.util.Date;

public class Team {
    private int id;
    private Date createDate;
    private User createBy;
    private String location;
    private String belongTo;
    private User leader;
    private String introduce;
    private String phoneNumber;
    private String email;
    private String is_delete;
    private Date delete_date;
    private String teamName;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", location='" + location + '\'' +
                ", belongTo='" + belongTo + '\'' +
                ", leader=" + leader +
                ", introduce='" + introduce + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", delete_date=" + delete_date +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
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

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
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

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public Date getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }
}
