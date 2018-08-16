package com.devperson.service;

import com.devperson.pojo.UserAccount;

import java.util.List;

public interface IUserService {

    public List<UserAccount> selectAllUser();

    public List<UserAccount> selectUserAccount();
}
