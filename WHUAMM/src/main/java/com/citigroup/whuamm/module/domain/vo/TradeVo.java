package com.citigroup.whuamm.module.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

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
public class TradeVo {
    private String tradeId;

    private String currencyId;

    private String buyerId;

    private String sellerId;

    /**
     * 单价
     */
    private Double price;

    private Double volume;

    private Date createTime;
}
