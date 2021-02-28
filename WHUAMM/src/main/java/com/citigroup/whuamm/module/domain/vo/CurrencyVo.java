package com.citigroup.whuamm.module.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 21:23
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyVo {

    private String currencyName;

    private String introduction;

    private String symbol;

    private Double liquidity;

    private Double volume;

    private Double price;

    /**
     * 价格变化（百分数）
     */
    private Double priceChange;
}
