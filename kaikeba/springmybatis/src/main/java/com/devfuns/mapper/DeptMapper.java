package com.devfuns.mapper;

import com.devfuns.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    List<Dept> selectDept();
    List<Dept> selectEmployeeByDeptNo(@Param(value = "deptNo") Integer deptNo);
    int insterDept(Dept dept);
    int insterBySelectKey(Dept dept);
}
