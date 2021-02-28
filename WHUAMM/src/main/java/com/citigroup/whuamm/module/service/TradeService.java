package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.module.dao.TradeDao;
import com.citigroup.whuamm.module.domain.vo.TradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 21:52
 * @lastEditor
 */
public interface TradeService {
    void saveTrade(TradeVo tradeVo);

    List<Integer> findVolumeChange(String  currencyId);

    List<Integer> findLiquidityChange(String  currencyId);

    List<TradeVo> findTradeByUser(String userId);
}
