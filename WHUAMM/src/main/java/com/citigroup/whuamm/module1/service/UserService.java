package com.citi.group.whuamm.module.service;

import com.citi.group.whuamm.module.domain.vo.RegisterVo;
import com.citi.group.whuamm.module.domain.vo.UserVo;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 18:57
 */
public interface UserService {
    UserVo register(RegisterVo registerVo);

    UserVo login(String loginNumber, String password);

}
