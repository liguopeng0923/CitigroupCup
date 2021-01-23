package com.citigroup.whuamm.module.controller;

import com.citigroup.whuamm.common.dto.ResponseDTO;
import com.citigroup.whuamm.module.domain.mapper.UserPostMapper;
import com.citigroup.whuamm.module.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 18:33
 */
@RestController
@RequestMapping("/api/anchor")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/anchorRegister")
    @Transactional(
            rollbackFor = Exception.class
    )
    public Map<String, Object> userRegister(@Validated UserPostMapper userPostMapper) {
        log.info("UserController.userRegister userPostMapper:{}", userPostMapper);
        return ResponseDTO.successBuilder()
                .addDataValue(userService.userRegister(userPostMapper))
                .map();
    }


    @PostMapping("/anchorLogin")
    @Transactional(
            rollbackFor = Exception.class
    )
    public Map<String, Object> userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        log.info("UserController.userLogin userName:{} password:{}", userName, password);
        return ResponseDTO.successBuilder()
                .addDataValue(userService.userLogin(userName, password))
                .map();
    }
}