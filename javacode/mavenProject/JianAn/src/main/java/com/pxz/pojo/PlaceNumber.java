package com.pxz.pojo;

public class PlaceNumber {
    private int id;
    private String place;
    private int realTimeNumber;
    private int maxPeople;
    private int state;
    private int administrators;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", realTimeNumber=" + realTimeNumber +
                ", maxPeople=" + maxPeople +
                ", state=" + state +
                ", administrators=" + administrators +
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

    public int getAdministrators() {
        return administrators;
    }

    public void setAdministrators(int administrators) {
        this.administrators = administrators;
    }
}
