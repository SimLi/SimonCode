package com.devfuns.service;

import com.devfuns.model.users.UserModel;

/**
 * Created by sim on 2018/8/29.
 */
public interface IAdminService {
    UserModel selectUserByNameAndPassword(String username, String password);
}
