package com.citi.group.poweru;

import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PoweruApplicationTests {

    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        RegisterVo registerVo = RegisterVo.builder()
                .loginNumber("1234567")
                .password("222222222")
                .build();
        System.out.println(userService.register(registerVo));


    }



}
