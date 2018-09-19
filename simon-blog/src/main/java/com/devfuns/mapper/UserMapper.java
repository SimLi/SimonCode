package com.devfuns.mapper;

import com.devfuns.model.users.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * Created by sim on 2018/8/29.
 */
public interface UserMapper {
    UserModel selectUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
