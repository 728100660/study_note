package com.pxz.pojo;

import java.util.Date;

public class Comment {
    private int id;
    private int createBy;
    private int articleId;
    private String content;
    private Date createDate;
    private int superiorCommentId;
    private boolean isDelete;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createBy=" + createBy +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", superiorCommentId=" + superiorCommentId +
                ", isDelete=" + isDelete +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcreateBy() {
        return createBy;
    }

    public void setcreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
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

    public boolean isisDelete() {
        return isDelete;
    }

    public void setisDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
