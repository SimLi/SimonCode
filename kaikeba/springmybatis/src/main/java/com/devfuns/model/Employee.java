package com.devfuns.model;

public class Employee {
    private int empId;
    private String empName;
    private Double empSal;
    private String empLoc;

    private int deptNo;

    private Dept dept;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public String getEmpLoc() {
        return empLoc;
    }

    public void setEmpLoc(String empLoc) {
        this.empLoc = empLoc;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSal=" + empSal +
                ", empLoc='" + empLoc + '\'' +
                ", deptNo=" + deptNo +
                ", dept=" + dept +
                '}';
    }
}
