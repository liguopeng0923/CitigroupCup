package com.citi.group.poweru.module.controller;

import com.citi.group.poweru.common.domain.ResponseDTO;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/17 20:44
 * @lastEditor
 */
@CrossOrigin
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/queryPoints")
    public ResponseDTO<List<PointInfoDto>> queryPointInfo(@RequestParam("adminId") @Valid Long adminId){
        log.info("AdminController.queryPointInfo adminId:{}", adminId);
        List<PointInfoDto> pointInfos = adminService.queryPointInfoByAdmin(adminId);
        return ResponseDTO.successData(pointInfos);
    }
}
