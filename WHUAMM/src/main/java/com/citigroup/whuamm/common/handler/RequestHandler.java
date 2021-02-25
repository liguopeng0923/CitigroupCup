package com.citigroup.whuamm.common.handler;

import com.citigroup.whuamm.common.dto.ResponseDTO;
import com.citigroup.whuamm.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class RequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    //    @ExceptionHandler({Exception.class})
//    @ResponseBody
//    public Map<String,Object> requestHandler(HttpServletRequest request, HttpServletResponse response,Exception e)
//    {
//        logger.error(e.getMessage());
//        ResponseDTO.Builder builder;
//        if(e instanceof BusinessException)
//        {
//            BusinessException exception = (BusinessException)e;
//            response.setStatus(exception.getCode());
//            builder = ResponseDTO.failedBuilder((exception));
//        }
//        else
//        {
//            builder = ResponseDTO.failedBuilder().addMessage("[RUNTIME]"+e.getMessage());
//        }
//        return builder.map();
//    }
    @ExceptionHandler(value = BusinessException.class)
    public Map<String,Object> requestHandler(BusinessException e)
    {
        return ResponseDTO.failedBuilder(e)
                .map();
    }

}