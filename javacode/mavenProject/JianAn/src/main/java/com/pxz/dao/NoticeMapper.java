package com.pxz.dao;

import com.pxz.pojo.Notice;
import com.pxz.pojo.NoticeHeader;
import com.pxz.pojo.NoticeLine;

import java.util.List;
import java.util.Map;


public interface NoticeMapper {
//    通知发布
    int createNotice(Map<String,Object> map);

    List<Notice> getNotices();
}
