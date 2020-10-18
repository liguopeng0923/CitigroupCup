package com.citi.group.poweru.handler;

import com.alibaba.fastjson.JSON;
import com.citi.group.poweru.common.domain.ResponseDTO;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author sunhuadong
 * @date 2020-05-04 18:45
 */
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter, @NonNull Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter methodParameter, @NonNull MediaType mediaType, @NonNull Class<? extends HttpMessageConverter<?>> aClass, @NonNull ServerHttpRequest serverHttpRequest, @NonNull ServerHttpResponse serverHttpResponse) {
        //如果返回的数据是Result类型则不进行封装
        if (body instanceof ResponseDTO) {
            return body;
        }

        ResponseDTO<Object> result = ResponseDTO.successData(body);
        //处理返回值是String的情况
        if (body instanceof String) {
            serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JSON.toJSONString(result);
        }
        return result;
    }

}
