package com.citigroup.whuamm.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 业务异常类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private int code;
    private String message;
    private String detail;

    public BusinessException(String message)
    {
        super(message);
        this.message = message;
        this.detail = "";
    }

    public BusinessException(String message,int code)
    {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BusinessException(String message,String detail)
    {
        super(message);
        this.detail = detail;
    }

    public BusinessException(int code,String message,String detail)
    {
        super(message);
        this.code = code;
        this.message = message;
        this.detail = detail;
    }
}
