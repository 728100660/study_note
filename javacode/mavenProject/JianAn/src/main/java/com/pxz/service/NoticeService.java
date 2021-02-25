package com.pxz.service;

import com.pxz.pojo.Notice;
import com.pxz.pojo.NoticeHeader;
import com.pxz.pojo.NoticeLine;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    //    通知发布
    int createNotice(Map<String,Object> map);

    //    查看通知
    List<Notice> getNotices();


}
