package com.citi.group.poweru;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.citi.group.poweru.module.dao.mapper")
public class PoweruApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoweruApplication.class, args);
    }

}
