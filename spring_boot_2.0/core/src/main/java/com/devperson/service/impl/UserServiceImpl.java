package com.devperson.service.impl;

import com.devperson.dao.UserDao;
import com.devperson.pojo.UserAccount;
import com.devperson.service.IUserService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserAccount> selectAllUser() {
        List<UserAccount> list = userDao.all();
        return list;
    }

    @Override
    public List<UserAccount> selectUserAccount() {
        return userDao.selectUserAccount();
    }
}
