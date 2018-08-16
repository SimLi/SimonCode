package com.devfuns.user.daoMapper;

import com.devfuns.user.entity.SpringUser;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUserDao extends BaseMapper<SpringUser> {
}
