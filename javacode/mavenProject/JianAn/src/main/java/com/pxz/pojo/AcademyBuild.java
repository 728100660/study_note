package com.pxz.pojo;

public class AcademyBuild {
    /**  教学楼  **/
    private int id;
    private String place;
    private String src;
    private int floor;
    private String index;

    @Override
    public String toString() {
        return "AcademyBuild{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", src='" + src + '\'' +
                ", floor=" + floor +
                ", index='" + index + '\'' +
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
