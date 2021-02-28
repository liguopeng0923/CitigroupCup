package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.module.domain.entity.CurrencyEntity;
import com.citigroup.whuamm.module.domain.vo.CurrencyVo;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/28 0:21
 * @lastEditor
 */
public interface CurrencyService {
    List<CurrencyVo> findAllCurrencyInfo();

    void addCurrency(CurrencyVo currencyVo);
}
