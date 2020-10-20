package com.citi.group.poweru.module.controller;

import com.citi.group.poweru.common.domain.ResponseDTO;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.domain.dto.QueryRankDto;
import com.citi.group.poweru.module.domain.vo.BindVo;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;
import com.citi.group.poweru.module.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/17 18:35
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户登录接口
     * @param phone 用户手机号
     * @param password 用户密码
     * @return 用户信息
     */
    @GetMapping("/login")
    public ResponseDTO<UserVo> login(@RequestParam("phone")String phone, @RequestParam("password")String password) {
        log.info("UserController.login phone:{}, password:{}", phone,password);
        UserVo login = userService.login(phone, password);
        return ResponseDTO.successData(login);
    }


    /**
     * 用户注册接口
     * @param registerVo 用户注册信息
     * @return 用户信息
     */
    @PostMapping("/register")
    public ResponseDTO<UserVo> register(@RequestBody @Valid RegisterVo registerVo) {
        log.info("UserController.register registerVo:{}", registerVo);
        UserVo register = userService.register(registerVo);
        return ResponseDTO.successData(register);
    }

    /**
     * 查询用户的所有基点的信息
     * @param userId 用户id
     * @return 基点信息列表
     */
    @GetMapping("/queryPoints")
    public ResponseDTO<List<PointInfoDto>> queryPointInfo(@RequestParam("userId") @Valid Long userId){
        log.info("UserController.queryPointInfo userId:{}", userId);
        List<PointInfoDto> pointInfos = userService.queryPointsInfoByUser(userId);
        return ResponseDTO.successData(pointInfos);
    }

    /**
     * 查询个人用户发电效率排行
     * @param queryRankVo 查询提供的信息，包括用户编号和查询年份
     * @return 用户每个月的日发电量的最大值，最小值和平均值，以及对应的日期
     */
    @GetMapping("/queryRank")
    public ResponseDTO<List<QueryRankDto>> queryGenerationRank(@RequestBody @Valid QueryRankVo queryRankVo){
        log.info("UserController.queryGenerationRank queryRankVo:{}", queryRankVo);
        List <QueryRankDto> queryResult = userService.queryStatisticalDataOfMonthGeneration(queryRankVo);
        return ResponseDTO.successData(queryResult);
    }

    /**
     * 用户绑定机器
     * @param bindVo 绑定信息
     * @return 绑定成功新生成的基站信息
     */
    @PostMapping("/bind")
    public ResponseDTO<PointInfoDto> bindMachine(@RequestBody @Valid BindVo bindVo){
        log.info("UserController.bindMachine bindVo:{}", bindVo);
        PointInfoDto pointInfoDto = userService.userBindPoint(bindVo);
        return ResponseDTO.successData(pointInfoDto);
    }
}
