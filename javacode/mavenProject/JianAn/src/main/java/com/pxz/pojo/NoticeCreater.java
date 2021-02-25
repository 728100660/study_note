package com.pxz.pojo;

import java.util.Date;

public class NoticeCreater {
    private int id;
    private int createBy;
    private int teamId;
    private String place;
    private Date date;
    private String content;
    private Date createDate;
    private boolean isDelete;

    @Override
    public String toString() {
        return "NoticeCreater{" +
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

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
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
