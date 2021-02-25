package com.pxz.pojo;

import java.util.Date;

public class User {
    private String name;
    private String school;
    private String authority;
    private String src;
    private String major;
    private String classes;
    private String academy;
    private String sex;
    private String identity_id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", authority='" + authority + '\'' +
                ", src='" + src + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", academy='" + academy + '\'' +
                ", sex='" + sex + '\'' +
                ", identity_id='" + identity_id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }
}
