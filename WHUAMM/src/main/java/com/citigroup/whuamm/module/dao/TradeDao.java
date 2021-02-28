package com.citigroup.whuamm.module.dao;

import com.citigroup.whuamm.module.domain.entity.TradeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 21:34
 * @lastEditor
 */
@Repository
public interface TradeDao{
    @Insert("insert into trade (tradeId,currencyId,buyerId,sellerId,price,volume,liquidity,turnover)values(#(tradeId),#(currencyId),#(buyerId),#(sellerId),#(price),#(volume),#(liquidity),#(turnover)")
    void saveTrade(TradeEntity trade);

    @Select("select volume from trade where currencyId=#(currencyId)")
    List<Integer> findVolumeChange(String currencyId);

    @Select("select liquidity from trade where currencyId=#(currencyId)")
    List<Integer> findLiquidityChange(String currencyId);

    @Select("select * from trade where sellerId=#{userId} or buyerId = userId")
    List<TradeEntity> findTradeByUser(String userId);
}
