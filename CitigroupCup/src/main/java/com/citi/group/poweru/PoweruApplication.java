package com.citi.group.poweru;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.citi.group.poweru.module.dao")
public class PoweruApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoweruApplication.class, args);
    }

}
