package com.dream.handler;

import com.dream.common.constant.ResponseCodeConst;
import com.dream.common.domain.ResponseDTO;
import com.dream.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Objects;

/**
 * @author sunhuadong
 * @date 2020-05-04 18:07
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * BusinessException 类捕获
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseDTO<String> handlerBusinessException(BusinessException e) {
        ResponseDTO<String> stringResponseDTO = new ResponseDTO<>();
        stringResponseDTO.setCode(e.getCode());
        stringResponseDTO.setMessage(e.getMessage());
        return stringResponseDTO;
    }

    /**
     * NoHandlerFoundException 404 异常处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseDTO<String> handlerNoHandlerFoundException(NoHandlerFoundException exception) {
        log.warn("[{}] {}: {}", NoHandlerFoundException.class.getSimpleName(), "NOT_FOUND", exception.getMessage());
        return ResponseDTO.wrap(ResponseCodeConst.NOT_FOUND);
    }

    /**
     * HttpRequestMethodNotSupportedException 405 异常处理
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseDTO<String> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.warn("[{}] {}: {}", HttpRequestMethodNotSupportedException.class.getSimpleName(), "METHOD_NOT_ALLOWED", exception.getMessage());
        return ResponseDTO.wrap(ResponseCodeConst.METHOD_NOT_ALLOWED);
    }

    /**
     * HttpMediaTypeNotSupportedException 415 异常处理
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseDTO<String> handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        log.warn("[{}] {}: {}", HttpMediaTypeNotSupportedException.class.getSimpleName(), "UNSUPPORTED_MEDIA_TYPE", exception.getMessage());
        return ResponseDTO.wrap(ResponseCodeConst.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * AccessDeniedException 没有权限异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseDTO<String> handlerAccessDeniedException(AccessDeniedException exception) {
        log.warn("[{}] {}: {}", AccessDeniedException.class.getSimpleName(), "ACCESS_DENIED", exception.getMessage());
        return ResponseDTO.wrap(ResponseCodeConst.ACCESS_DENIED);
    }

    /**
     * Exception 类捕获 500 异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseDTO<String> handlerException(Exception e) {
        return ifDepthExceptionType(e);
    }

    /**
     * 二次深度检查错误类型
     */
    private ResponseDTO<String> ifDepthExceptionType(Throwable throwable) {
        Throwable cause = throwable.getCause();
        if (cause instanceof BusinessException) {
            return handlerBusinessException((BusinessException) cause);
        }
        log.error("[{}] {}: {}", Exception.class.getSimpleName(), "EXCEPTION", throwable.getMessage(), throwable);
        return ResponseDTO.wrap(ResponseCodeConst.EXCEPTION);
    }


    /**
     * HttpMessageNotReadableException 参数错误异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDTO<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("[{}] {}: {}", HttpMessageNotReadableException.class.getSimpleName(), "ERROR_PARAM", exception.getMessage(), exception);
        String msg = String.format("错误详情( %s )", Objects.requireNonNull(exception.getRootCause()).getMessage());
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM, msg);
    }

    /**
     * ServletRequestBindingException 参数错误异常
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseDTO<String> handleServletRequestBindingException(ServletRequestBindingException exception) {
        log.error("[{}] {}: {}", ServletRequestBindingException.class.getSimpleName(), "ERROR_PARAM", exception.getMessage(), exception);
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
    }

    /**
     * BindException 参数错误异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseDTO<String> handleMethodArgumentNotValidException(BindException exception) {
        if (log.isDebugEnabled()) {
            log.error("[{}] {}: {}", BindException.class.getSimpleName(), "ERROR_PARAM", exception.getMessage(), exception);
        } else {
            log.error("[{}] {}: {}", BindException.class.getSimpleName(), "ERROR_PARAM", exception.getMessage());
        }
        BindingResult bindingResult = exception.getBindingResult();
        return getBindResultDTO(bindingResult);
    }

    private ResponseDTO<String> getBindResultDTO(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (log.isDebugEnabled()) {
            for (FieldError error : fieldErrors) {
                log.error("{} -> {}", error.getDefaultMessage(), error.getDefaultMessage());
            }
        }

        if (fieldErrors.isEmpty()) {
            log.error("validExceptionHandler error fieldErrors is empty" );
            return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
        }
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM, fieldErrors.get(0).getDefaultMessage());
    }

}
