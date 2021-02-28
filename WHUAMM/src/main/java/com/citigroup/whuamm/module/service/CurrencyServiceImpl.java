package com.citigroup.whuamm.module.service;

import com.citigroup.whuamm.module.dao.CurrencyDao;
import com.citigroup.whuamm.module.domain.entity.CurrencyEntity;
import com.citigroup.whuamm.module.domain.vo.CurrencyVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/28 0:21
 * @lastEditor
 */
@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Resource
    private CurrencyDao currencyDao;

    @Override
    public List<CurrencyVo> findAllCurrencyInfo() {
        List<CurrencyEntity> currencies = currencyDao.findAllCurrency();
        List<CurrencyVo> currencyVos = new ArrayList<>();

        for (CurrencyEntity currency:currencies){
            CurrencyVo cVo = new CurrencyVo();
            cVo.setCurrencyName(currency.getCurrencyName());
            cVo.setSymbol(currency.getSymbol());
            cVo.setIntroduction(currency.getIntroduction());
            cVo.setVolume(currency.getVolume());
            cVo.setLiquidity(currency.getLiquidity());
            cVo.setPrice(currency.getPrice());
            cVo.setPriceChange(currency.getPriceChange());
            currencyVos.add(cVo);
        }
        return currencyVos;
    }

    @Override
    public void addCurrency(CurrencyVo currencyVo) {
        CurrencyEntity currency = new CurrencyEntity();

        currency.setCurrencyName(currencyVo.getCurrencyName());
        currency.setSymbol(currencyVo.getSymbol());
        currency.setIntroduction(currencyVo.getIntroduction());
        currency.setLiquidity(currencyVo.getLiquidity());
        currency.setVolume(0.0);
        currency.setPrice(currencyVo.getPrice());
        currency.setPriceChange(0.0);

        currencyDao.addCurrency(currency);
    }
}
