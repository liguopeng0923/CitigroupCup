package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.common.exception.BusinessException;
import com.citigroup.whuamm.module.dao.UserDao;
import com.citigroup.whuamm.module.domain.bo.User;
import com.citigroup.whuamm.module.domain.bo.UserData;
import com.citigroup.whuamm.module.domain.entity.UserEntity;
import com.citigroup.whuamm.module.domain.mapper.UserDetailMapper;
import com.citigroup.whuamm.module.domain.mapper.UserPostMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 17:51
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> userRegister(UserPostMapper userPostMapper) {

        User user = userPostMapper.build();
        userDao.save(UserData.convert(user,new UserEntity()));
        return UserDetailMapper.buildMap(user);
    }

    @Override
    public Map<String, Object> uaerLogin(String userName, String password) {
        UserEntity userEntity = userDao.findByUserNameAndPassword(userName,password);
        if(Objects.isNull(userEntity))
        {
            throw new BusinessException("用户名或密码错误");
        }
        return UserDetailMapper.buildMap(UserData.convert(userEntity,new User()));
    }

}
