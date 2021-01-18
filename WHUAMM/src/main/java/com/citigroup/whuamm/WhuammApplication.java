package com.citigroup.whuamm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.citigroup.whuamm.module.domain.entity")
public class WhuammApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhuammApplication.class, args);
    }

}
