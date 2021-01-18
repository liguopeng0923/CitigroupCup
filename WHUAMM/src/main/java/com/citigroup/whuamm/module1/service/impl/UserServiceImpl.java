package com.citigroup.whuamm.module1.service.impl;

import com.citi.group.whuamm.module.domain.entity.UserEntity;
import com.citi.group.whuamm.module.domain.vo.RegisterVo;
import com.citi.group.whuamm.module.domain.vo.UserVo;
import com.citi.group.whuamm.module.service.UserService;
import com.citigroup.whuamm.module1.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

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

        UserEntity anchor = registerVo.build();
        anchorDao.save(AnchorData.convert(anchor,new AnchorEntity()));
        AnchorInfoEntity anchorInfoEntity = AnchorInfoEntity.builder()
                .id(UUID.randomUUID().toString().replace("-","").toUpperCase().substring(0,32))
                .anchorId(anchor.getId())
                .status(Status.OK)
                .build();
        anchorInfoDao.save(anchorInfoEntity);
        return AnchorDetailMapper.buildMap(anchor);
    }

    @Override
    public UserVo login(String loginNumber, String password) {
        UserEntity userEntity = userMapper.selectByPhoneAndPassword(loginNumber, password);
        if(Objects.nonNull(userEntity)){
            return UserVo.builder()
                    .id()
                    .phone()
                    .address()
                    .birthday()
                    .cardId()
                    .contactName()
                    .credit()
                    .email()
                    .gender()
                    .information()
                    .name()
                    .photo()
                    .balance()
                    .realName()
                    .build();
        }
        return null;
    }
}
