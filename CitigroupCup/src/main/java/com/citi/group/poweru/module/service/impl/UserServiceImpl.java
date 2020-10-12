package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.UserMapper;
import com.citi.group.poweru.module.domain.entity.UserEntity;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;
import com.citi.group.poweru.module.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 19:07
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserVo register(RegisterVo registerVo) {
        UserEntity userEntity = UserEntity.builder()
                .name(registerVo.getNickname())
                .phone(registerVo.getLoginNumber())
                .password(registerVo.getPassword())
                .access(0)
                .build();
        userMapper.insertUser(userEntity);

        return UserVo.builder()
                .phone(userEntity.getPhone())
                .id(userEntity.getId()).build();
    }

    @Override
    public UserVo login(String loginNumber, String password) {
//        UserEntity userEntity = userMapper.selectByPhoneAndPassword(loginNumber, password);
//        if(Objects.nonNull(userEntity)){
//            return UserVo.builder()
//                    .id()
//                    .phone()
//                    .address()
//                    .birthday()
//                    .cardId()
//                    .contactName()
//                    .credit()
//                    .email()
//                    .gender()
//                    .information()
//                    .name()
//                    .photo()
//                    .profit()
//                    .realName()
//                    .build()
//        }
        return null;
    }
}
