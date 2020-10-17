package com.citi.group.poweru.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sunhuadong
 * @date 2020/7/14 11:41 下午
 */
@Component
public class Consul {

    @Value("${spring.profiles.active}")
    private String env;

    private static final String DREAM_WHU_CAS_DEV = "http://47.99.197.178:8081";
    private static final String DREAM_WHU_CAS_TEST = "http://47.99.197.178:8081";
    private static final String DREAM_WHU_CAS_PROD = "http://127.0.0.1:8081";

    public String getDreamWhuCasServiceUrl() {
        if ("dev".equals(env)) {
            return DREAM_WHU_CAS_DEV;
        } else if ("prod".equals(env)) {
            return DREAM_WHU_CAS_PROD;
        } else if ("test".equals(env)) {
            return DREAM_WHU_CAS_TEST;
        }
        throw new RuntimeException("invalid env");
    }
}
