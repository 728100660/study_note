package com.pxz.dao;

import com.pxz.pojo.AcademyBuild;
import com.pxz.pojo.ClassRoomNumber;
import com.pxz.pojo.Notice;
import com.pxz.pojo.Place;

import java.util.List;
import java.util.Map;

public interface PlaceMapper {
/**
 * 跟地点有关的都在这里获取，如，class， academybuild，placenumber等*/
//    设置场所状态
    int setStatus(Map<String, Object> map);

//    获取场所
    List<Place> getPlace();

//  获取教学楼信息
    List<AcademyBuild> getAcademyBuildInfo(String place);

//    获取教室的人数
    List<ClassRoomNumber> getClassRoomNumber(String index);
}
