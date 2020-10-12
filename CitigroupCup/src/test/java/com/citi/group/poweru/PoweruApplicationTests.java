package com.citi.group.poweru;

import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoweruApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        RegisterVo registerVo = RegisterVo.builder()
                .nickname("11")
                .loginNumber("1234567")
                .password("222222222")
                .build();
        System.out.println(userService.register(registerVo));


    }


}
