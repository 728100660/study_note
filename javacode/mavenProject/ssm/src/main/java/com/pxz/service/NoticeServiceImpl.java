package com.pxz.service;

import com.pxz.dao.NoticeMapper;
import com.pxz.pojo.NoticeHeader;
import com.pxz.pojo.NoticeLine;

import java.util.List;
import java.util.Map;

public class NoticeServiceImpl implements NoticeService {
    private NoticeMapper noticeMapper;

    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public int createNoticeHeader(NoticeHeader noticeHeader) {
        return noticeMapper.createNoticeHeader(noticeHeader);
    }

    @Override
    public int createNoticeLine(Map<String,Object> map) {
        return noticeMapper.createNoticeLine(map);
    }

    @Override
    public int receiveNoticeLine(Map<String, Object> map) {
        return noticeMapper.receiveNoticeLine(map);
    }

    @Override
    public int deleteNoticeLine(Map<String, Object> map) {
        return noticeMapper.deleteNoticeLine(map);
    }

    @Override
    public List<NoticeLine> getNotices(Map<String, Object> map) {
        return noticeMapper.getNotices(map);
    }

    @Override
    public List<NoticeHeader> getNoticesCreated(int createBy) {
        return noticeMapper.getNoticesCreated(createBy);
    }
}
