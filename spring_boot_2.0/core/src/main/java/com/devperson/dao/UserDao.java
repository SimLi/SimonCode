package com.devperson.dao;

import com.devperson.pojo.UserAccount;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<UserAccount> {
    public List<UserAccount> selectUserAccount();
}
