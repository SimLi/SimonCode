package com.devfuns.dept.controller;

import com.devfuns.dept.daoMapper.SpringDeptMapperDao;
import com.devfuns.dept.entity.SpringDept;
import com.devfuns.dept.pojo.CloudUser;
import com.devfuns.dept.userFeign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class SpringDeptController {

    @Autowired
    SpringDeptMapperDao springDeptMapper;

    @Autowired
    UserFeignClient userFeignClient;

    @RequestMapping("/getDeptByUserId")
    public SpringDept getDeptByUserId(Integer deptId) {
        return springDeptMapper.single(deptId);
    }

    @RequestMapping("/insterDept")
    public SpringDept insterDept(SpringDept springDept) {
        springDeptMapper.insert(springDept,true);
        return springDept;
    }

    @RequestMapping("/findDeptUserById")
    public Map findUserById(Integer userId) {
        System.out.println("difff");
        return userFeignClient.findUserById(userId);
    }

    @RequestMapping("/selectUserByUser")
    public List<CloudUser> selectUserByUser(String userName, String actName) {
        return userFeignClient.selectUserByUser(userName,actName);
    }

    @RequestMapping("/selectUserByUserMapParam")
    public List<CloudUser> selectUserByUserMapParam(String userName, String actName) {
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("actName",actName);
        return userFeignClient.selectUserByUserMapParam(params);
    }

}
