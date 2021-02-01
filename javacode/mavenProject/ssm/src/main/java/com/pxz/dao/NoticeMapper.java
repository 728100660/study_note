package com.pxz.dao;

import com.pxz.pojo.NoticeHeader;
import com.pxz.pojo.NoticeLine;

import java.util.List;
import java.util.Map;


public interface NoticeMapper {
//    通知主题内容
    int createNoticeHeader(NoticeHeader noticeHeader);
//    通知分配行
    int createNoticeLine(Map<String,Object> map);
//    成员确认接收到通知
    int receiveNoticeLine(Map<String,Object> map);

//    接收人人发布的信息太多了本地删除
    int deleteNoticeLine(Map<String,Object> map);

//    int deleteNoticeHeader(Map<String,Object> map);

//    查看自己接收的通知
    List<NoticeLine> getNotices(Map<String,Object> map);

//    查看自己发布的
    List<NoticeHeader> getNoticesCreated(int createBy);
}
