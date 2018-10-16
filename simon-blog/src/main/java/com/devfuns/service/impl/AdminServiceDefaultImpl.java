package com.devfuns.service.impl;

import com.devfuns.core.utils.JavaMDUtils;
import com.devfuns.exception.ServiceException;
import com.devfuns.mapper.UserMapper;
import com.devfuns.model.users.UserModel;
import com.devfuns.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by sim on 2018/8/29.
 */
@Service
public class AdminServiceDefaultImpl implements IAdminService {

    @Resource
    UserMapper userMapper;


    @Override
    public UserModel selectUserByNameAndPassword(String username, String password) {

        // 参数非空验证
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ServiceException("用户名和密码不能为空");
        }

        return userMapper.selectUserByNameAndPassword(username, JavaMDUtils.commonsCodecMD5(password));
    }
}
