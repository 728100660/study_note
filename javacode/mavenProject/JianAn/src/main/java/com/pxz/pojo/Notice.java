package com.pxz.pojo;

import java.util.Date;

public class Notice {
    private int id;
    private String place;
    private String title;
    private Date release_time;
    private String content;
    private int publisher;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", title='" + title + '\'' +
                ", release_time=" + release_time +
                ", content='" + content + '\'' +
                ", publisher=" + publisher +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }
}
