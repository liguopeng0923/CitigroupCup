package com.dream.common.exception;

import lombok.Getter;

/**
 * 业务异常类
 *
 * @author sunhuadong
 * @date 2020-05-04 17:49
 */

public class BusinessException extends RuntimeException {

    @Getter
    private int code = 1;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
}
