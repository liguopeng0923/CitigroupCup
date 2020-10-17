package com.citi.group.poweru.module.controller;

import com.citi.group.poweru.common.domain.ResponseDTO;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;
import com.citi.group.poweru.module.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/17 18:35
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseDTO<UserVo> login(@RequestParam("phone") @Valid String phone, @RequestParam("password") @Valid String password) {
        log.info("UserController.login phone:{}, password:{}", phone,password);
        UserVo login = userService.login(phone, password);
        return ResponseDTO.successData(login);
    }

    @PostMapping("/register")
    public ResponseDTO<UserVo> register(@RequestParam("registerVo") @Valid RegisterVo registerVo) {
        log.info("UserController.register registerVo:{}", registerVo);
        UserVo register = userService.register(registerVo);
        return ResponseDTO.successData(register);
    }
}
