package com.devfuns.service;

import com.devfuns.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sim on 2018/8/21.
 */
public interface IDeptService {
    List<Dept> selectDept();
    List<Dept> selectEmployeeByDeptNo(@Param(value = "deptNo") Integer deptNo);
    int insterDept(Dept dept);
    int insterBySelectKey(Dept dept);
}
