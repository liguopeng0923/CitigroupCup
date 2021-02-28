package com.citigroup.whuamm.module.controller;

import com.citigroup.whuamm.common.dto.ResponseDTO;
import com.citigroup.whuamm.module.domain.mapper.UserPostMapper;
import com.citigroup.whuamm.module.domain.vo.TradeVo;
import com.citigroup.whuamm.module.service.TradeService;
import com.citigroup.whuamm.module.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 22:54
 * @lastEditor
 */
@RestController
@RequestMapping("/api/trade")
@Slf4j
public class TradeController {
    @Resource
    private TradeService tradeService;

    @PostMapping("/saveTrade")
    @Transactional(
            rollbackFor = Exception.class
    )
    public void saveTrade(@Validated TradeVo tradeVo) {
        log.info("TradeController.saveTrade tradeVo:{}", tradeVo);
        tradeService.saveTrade(tradeVo);
    }

//    @PostMapping("/queryTrade")
//    @Transactional(
//            rollbackFor = Exception.class
//    )
//    public void findTradeByUser(String userId){
//
//    }
}
