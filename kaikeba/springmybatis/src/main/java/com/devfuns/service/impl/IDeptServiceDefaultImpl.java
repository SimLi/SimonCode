package com.devfuns.service.impl;

import com.devfuns.mapper.DeptMapper;
import com.devfuns.model.Dept;
import com.devfuns.service.IDeptService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sim on 2018/8/21.
 */
@Service
public class IDeptServiceDefaultImpl implements IDeptService {

    @Resource
    DeptMapper deptMapper;

    public List<Dept> selectDept() {
        return deptMapper.selectDept();
    }

    public List<Dept> selectEmployeeByDeptNo(Integer deptNo) {
        return deptMapper.selectEmployeeByDeptNo(deptNo);
    }

    public int insterDept(Dept dept) {
        return deptMapper.insterDept(dept);
    }

    public int insterBySelectKey(Dept dept) {
        return deptMapper.insterBySelectKey(dept);
    }
}
