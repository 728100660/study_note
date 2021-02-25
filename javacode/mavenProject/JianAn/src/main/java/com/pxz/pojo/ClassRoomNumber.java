package com.pxz.pojo;

public class ClassRoomNumber {
    private int id;
    private String place;
    private int realTimeNumber;
    private int maxPeople;
    private int state;
    private int administrator;

    @Override
    public String toString() {
        return "ClassRoomNumber{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", realTimeNumber=" + realTimeNumber +
                ", maxPeople=" + maxPeople +
                ", state=" + state +
                ", administrator=" + administrator +
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

    public int getRealTimeNumber() {
        return realTimeNumber;
    }

    public void setRealTimeNumber(int realTimeNumber) {
        this.realTimeNumber = realTimeNumber;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }
}
