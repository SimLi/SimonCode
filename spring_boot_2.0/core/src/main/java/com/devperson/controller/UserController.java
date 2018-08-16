package com.devperson.controller;

import com.devperson.dao.UserDao;
import com.devperson.pojo.UserAccount;
import com.devperson.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userServiceImpl;

    @Autowired
    UserDao userDao;

    @RequestMapping("/selectAll")
    public List<UserAccount> selectAllUser() {
        System.out.println("测试热加载AAA");
        return userServiceImpl.selectAllUser();
    }

    @RequestMapping("/selectUserAccount")
    public List<UserAccount> selectUserAccount() {
        return userServiceImpl.selectUserAccount();
    }

    @RequestMapping("/inster")
    public UserAccount inster(UserAccount userAccount) {
        userDao.insert(userAccount);
        return userAccount;
    }
}
