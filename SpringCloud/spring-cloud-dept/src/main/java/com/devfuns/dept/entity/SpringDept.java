package com.devfuns.dept.entity;

import java.io.Serializable;

public class SpringDept implements Serializable {
    private Integer deptId;
    private String deptName;
    private String deptNo;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "SpringDept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptNo='" + deptNo + '\'' +
                '}';
    }
}
