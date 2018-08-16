package com.devfuns.user.controller;

import com.devfuns.user.daoMapper.SpringUserDao;
import com.devfuns.user.entity.SpringUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    SpringUserDao springUserDao;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getUSerList")
    public List<SpringUser> getUSerList() {
        return springUserDao.all();
    }

    @RequestMapping("/insterUser")
    public Integer insterUser( SpringUser springUser) {
        springUserDao.insert(springUser,true);
        return springUser.getUserId();
    }


    @RequestMapping("/findUserById/{id}")
    public SpringUser findUserById( @PathVariable("id") Integer userId){
        return springUserDao.single(userId);
    }

    @RequestMapping("/getUserDept")
    public Map getUserDept(Integer deptId) {
        Map map = null;
        try {
            map = restTemplate.getForObject("http://spring-dept/spring-dept/dept/getDeptByUserId?deptId="+deptId,
                    Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/selectUserByUser")
    public List<SpringUser> selectUserByUser( String userName,String actName) {
        SpringUser springUser = new SpringUser();
        springUser.setActName(actName);
        springUser.setUserName(userName);
        return springUserDao.template(springUser);
    }
}
