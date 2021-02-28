package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.module.dao.CurrencyDao;
import com.citigroup.whuamm.module.dao.TradeDao;
import com.citigroup.whuamm.module.domain.entity.TradeEntity;
import com.citigroup.whuamm.module.domain.vo.TradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 21:52
 * @lastEditor
 */
@Service
public class TradeServiceImpl implements TradeService{
    @Resource
    private TradeDao tradeDao;

    @Resource
    private CurrencyDao currencyDao;

    @Override
    public void saveTrade(TradeVo tradeVo) {
        TradeEntity trade = new TradeEntity();
        trade.setTradeId(UUID.randomUUID().toString().replace("-","").toUpperCase().substring(0,32));
        trade.setBuyerId(tradeVo.getBuyerId());
        trade.setSellerId(tradeVo.getSellerId());
        trade.setCurrencyId(tradeVo.getCurrencyId());
        double liquidity = currencyDao.findLiquidity(tradeVo.getCurrencyId())-tradeVo.getVolume();
        trade.setLiquidity(liquidity);
        trade.setPrice(tradeVo.getPrice());
        trade.setVolume(tradeVo.getVolume());
        trade.setTurnover(tradeVo.getPrice()*tradeVo.getVolume());
        tradeDao.saveTrade(trade);

        DecimalFormat df   = new DecimalFormat("######0.00");
        double oldPrice = currencyDao.findPriceById(tradeVo.getCurrencyId());
        double newPrice = (oldPrice+tradeVo.getPrice())/2.0;
        double priceChange = Math.abs(newPrice - oldPrice)/oldPrice;
        df.format(priceChange);
        currencyDao.updatePrice(newPrice);
        currencyDao.updateLiquidity(liquidity);
        currencyDao.updateVolume(currencyDao.findVolumeById(tradeVo.getCurrencyId())+tradeVo.getVolume());
        currencyDao.updatePriceChange(priceChange);
    }

    @Override
    public List<Integer> findVolumeChange(String currencyId) {
        return tradeDao.findVolumeChange(currencyId);
    }

    @Override
    public List<Integer> findLiquidityChange(String  currencyId) {
        return tradeDao.findLiquidityChange(currencyId);
    }

    @Override
    public List<TradeVo> findTradeByUser(String userId) {
        return null;
    }
}
