package com.pxz.pojo;

import java.util.Date;

public class Comment {
    private int id;
    private int createby;
    private int articleId;
    private String varchar;
    private Date createDate;
    private int superiorCommentId;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createby=" + createby +
                ", articleId=" + articleId +
                ", varchar='" + varchar + '\'' +
                ", createDate=" + createDate +
                ", superiorCommentId=" + superiorCommentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreateby() {
        return createby;
    }

    public void setCreateby(int createby) {
        this.createby = createby;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSuperiorCommentId() {
        return superiorCommentId;
    }

    public void setSuperiorCommentId(int superiorCommentId) {
        this.superiorCommentId = superiorCommentId;
    }
}
