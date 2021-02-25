package com.pxz.pojo;

import java.util.Date;

public class NoticeHeader {
    private int id;
    private User createBy;
    private Team teamId;
    private String place;
    private Date date;
    private String content;
    private Date createDate;
    private boolean isDelete;

    @Override
    public String toString() {
        return "NoticeHeader{" +
                "id=" + id +
                ", createBy=" + createBy +
                ", teamId=" + teamId +
                ", place='" + place + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
