package com.pxz.pojo;

public class Article {
    private int id;
    private int createBy;
    private int teamId;
    private String title;
    private String content;
    private boolean isDelete;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", createBy=" + createBy +
                ", teamId=" + teamId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
