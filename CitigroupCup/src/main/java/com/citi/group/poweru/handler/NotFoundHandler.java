package com.citi.group.poweru.handler;

import com.citi.group.poweru.common.constant.ResponseCodeConst;
import com.citi.group.poweru.common.domain.ResponseDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunhuadong
 * @date 2020/5/22 3:22 下午
 */
@Controller
public class NotFoundHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = {"/error"})
    @ResponseBody
    public Object error() {
        return ResponseDTO.wrap(ResponseCodeConst.NOT_FOUND);
    }
}
