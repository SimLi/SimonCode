package com.devfuns.user.entity;

import java.io.Serializable;
import java.util.Date;

public class SpringUser implements Serializable {

    private Integer userId;
    private String userName;
    private String actName;
    private Date briDate;
    private Integer deptId;
    private String phon;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public Date getBriDate() {
        return briDate;
    }

    public void setBriDate(Date briDate) {
        this.briDate = briDate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getPhon() {
        return phon;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }

    @Override
    public String toString() {
        return "SpringUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", actName='" + actName + '\'' +
                ", briDate=" + briDate +
                ", deptId=" + deptId +
                ", phon='" + phon + '\'' +
                '}';
    }
}
