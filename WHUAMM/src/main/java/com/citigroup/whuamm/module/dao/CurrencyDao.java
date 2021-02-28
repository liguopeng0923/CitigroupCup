package com.citigroup.whuamm.module.dao;

import com.citigroup.whuamm.module.domain.entity.CurrencyEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 21:35
 * @lastEditor
 */
@Repository
public interface CurrencyDao {
    @Select("select liquidity from currencyInfo where id=#{currencyId}")
    Double findLiquidity(String currencyId);

    @Select("select * from currencyInfo")
    List<CurrencyEntity> findAllCurrency();

    @Select("select price from currencyInfo where id=#{currencyId}")
    Double findPriceById(String currencyId);

    @Select("select volume from currencyInfo where id=#{currencyId}")
    Double findVolumeById(String currencyId);

    @Update("update currency set price=#{price}")
    void updatePrice(Double price);

    @Update("update currency set priceChange=#{priceChange}")
    void updatePriceChange(Double priceChange);

    @Update("update currency set volume=#{volume}")
    void updateVolume(Double volume);

    @Update("update currency set liquidity=#{liquidity}")
    void updateLiquidity(Double liquidity);

    @Insert("insert into currency (currencyName,symbol,introduction,price,volume,liquidity,priceChange)values(#(currencyName),#(symbol),#{introduction},#(price),#(volume),#(liquidity),#(priceChange)")
    void addCurrency(CurrencyEntity currency);

}
