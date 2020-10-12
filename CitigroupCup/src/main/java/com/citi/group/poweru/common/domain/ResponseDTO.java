package com.dream.common.domain;

import com.alibaba.fastjson.JSON;
import com.dream.common.constant.ResponseCodeConst;
import lombok.Data;

/**
 * @author sunhuadong
 * @date 2020-05-04 17:56
 */
@Data
public class ResponseDTO<T> {

    protected Integer code;

    protected String message;

    protected Boolean success;

    protected T data;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, String message) {
        this.code = responseCodeConst.getCode();
        this.message = message;
        this.success = responseCodeConst.isSuccess();
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, T data) {
        super();
        this.code = responseCodeConst.getCode();
        this.message = responseCodeConst.getMsg();
        this.data = data;
        this.success = responseCodeConst.isSuccess();
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, T data, String message) {
        super();
        this.code = responseCodeConst.getCode();
        this.message = message;
        this.data = data;
        this.success = responseCodeConst.isSuccess();
    }

    private ResponseDTO(ResponseCodeConst responseCodeConst) {
        this.code = responseCodeConst.getCode();
        this.message = responseCodeConst.getMsg();
        this.success = responseCodeConst.isSuccess();
    }

    public ResponseDTO(ResponseDTO<T> responseDTO) {
        this.code = responseDTO.getCode();
        this.message = responseDTO.getMessage();
        this.data = null;
        this.success = responseDTO.isSuccess();
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<T>(ResponseCodeConst.SUCCESS);
    }

    public static <T> ResponseDTO<T> successData(T data, String message) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCCESS, data, message);
    }

    public static <T> ResponseDTO<T> successData(T data) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCCESS, data);
    }

    public static <T> ResponseDTO<T> successMsg(String message) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCCESS, message);
    }


    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst) {
        return new ResponseDTO<>(codeConst);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst, T t) {
        return new ResponseDTO<T>(codeConst, t);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst, String message) {
        return new ResponseDTO<T>(codeConst, message);
    }

    public String getMessage() {
        return message;
    }

    public ResponseDTO<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseDTO<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseDTO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
