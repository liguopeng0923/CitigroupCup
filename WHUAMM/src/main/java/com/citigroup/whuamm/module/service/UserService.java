package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.common.exception.BusinessException;
import com.citigroup.whuamm.module.domain.bo.User;
import com.citigroup.whuamm.module.domain.bo.UserData;
import com.citigroup.whuamm.module.domain.entity.UserEntity;
import com.citigroup.whuamm.module.domain.mapper.UserDetailMapper;
import com.citigroup.whuamm.module.domain.mapper.UserPostMapper;

import java.util.Map;
import java.util.Objects;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 18:32
 */
public interface UserService {
    public Map<String, Object> userRegister(UserPostMapper userPostMapper);

    public Map<String, Object> userLogin(String userName, String password);
}
