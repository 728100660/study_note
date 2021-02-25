package com.pxz.service;

import com.pxz.pojo.AcademyBuild;
import com.pxz.pojo.ClassRoomNumber;
import com.pxz.pojo.Place;

import java.util.List;
import java.util.Map;

public interface PlaceService {
    int setStatus(Map<String, Object> map);

    //    获取场所
    List<Place> getPlace();


    //  获取教学楼信息
    List<AcademyBuild> getAcademyBuildInfo(String place);

    //    获取教室的人数
    List<ClassRoomNumber> getClassRoomNumber(String index);
}
