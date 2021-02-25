package com.pxz.service;

import com.pxz.dao.NoticeMapper;
import com.pxz.pojo.Notice;
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
    public int createNotice(Map<String, Object> map) {
        return noticeMapper.createNotice(map);
    }

    @Override
    public List<Notice> getNotices(){
        return noticeMapper.getNotices();
    }

}
