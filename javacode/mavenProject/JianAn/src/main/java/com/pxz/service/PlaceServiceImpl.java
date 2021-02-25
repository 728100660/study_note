package com.pxz.service;

import com.pxz.dao.PlaceMapper;
import com.pxz.pojo.AcademyBuild;
import com.pxz.pojo.ClassRoomNumber;
import com.pxz.pojo.Place;

import java.util.List;
import java.util.Map;

public class PlaceServiceImpl implements PlaceService{

    PlaceMapper placeMapper;

    public void setPlaceMapper(PlaceMapper placeMapper) {
        this.placeMapper = placeMapper;
    }

    @Override
    public int setStatus(Map<String, Object> map) {
        return placeMapper.setStatus(map);
    }

    @Override
    public List<Place> getPlace() {
        return placeMapper.getPlace();
    }

    @Override
    public List<AcademyBuild> getAcademyBuildInfo(String place) {
        return placeMapper.getAcademyBuildInfo(place);
    }

    @Override
    public List<ClassRoomNumber> getClassRoomNumber(String index) {
        return placeMapper.getClassRoomNumber(index);
    }
}
