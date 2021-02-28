package com.citigroup.whuamm.module.controller;

import com.citigroup.whuamm.module.domain.vo.CurrencyVo;
import com.citigroup.whuamm.module.service.CurrencyService;
import com.citigroup.whuamm.module.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/28 0:43
 * @lastEditor
 */
@RestController
@RequestMapping("/api/currency")
@Slf4j
public class CurrencyController {

    @Resource
    private TradeService tradeService;

    @Resource
    private CurrencyService currencyService;

    @RequestMapping("/currencyInfo")
    @Transactional(
            rollbackFor = Exception.class
    )
    public List<CurrencyVo> AllCurrencyInfo(){
        return currencyService.findAllCurrencyInfo();
    }

    @PostMapping("/liquidityChange")
    @Transactional(
            rollbackFor = Exception.class
    )
    public List<Integer> CurrencyLiquidityChange(@Validated String currencyId){
        return tradeService.findLiquidityChange(currencyId);
    }

    @PostMapping("/volumeChange")
    @Transactional(
            rollbackFor = Exception.class
    )
    public List<Integer> CurrencyVolumeChange(@Validated String currencyId){
        return tradeService.findVolumeChange(currencyId);
    }

    @PostMapping("/addCurrency")
    @Transactional(
            rollbackFor = Exception.class
    )
    public void addCurrency(@Validated CurrencyVo currencyVo){
        currencyService.addCurrency(currencyVo);
    }
}
