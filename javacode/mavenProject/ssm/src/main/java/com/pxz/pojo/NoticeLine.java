package com.pxz.pojo;

public class NoticeLine {
    private int id;
    private NoticeHeader noticeId;
    private int userId;
    private boolean received;
    private boolean isDelete;
    private int noticeHeaderId;

    @Override
    public String toString() {
        return "NoticeLine{" +
                "id=" + id +
                ", noticeId=" + noticeId +
                ", userId=" + userId +
                ", received=" + received +
                ", isDelete=" + isDelete +
                ", noticeHeaderId=" + noticeHeaderId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NoticeHeader getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(NoticeHeader noticeId) {
        this.noticeId = noticeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getNoticeHeaderId() {
        return noticeHeaderId;
    }

    public void setNoticeHeaderId(int noticeHeaderId) {
        this.noticeHeaderId = noticeHeaderId;
    }
}
