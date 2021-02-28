package com.citigroup.whuamm.module.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2021/2/27 16:50
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trade")
public class TradeEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tradeId",nullable = false)
    private String tradeId;

    @Column(name = "currencyId",nullable = false)
    private String currencyId;

    @Column(name = "buyerId",nullable = false)
    private String buyerId;

    @Column(name = "sellerId",nullable = false)
    private String sellerId;

    /**
     * 单价
     */
    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "volume",nullable = false)
    private Double volume;

    @Column(name = "liquidity",nullable = false)
    private Double liquidity;

    @Column(name = "turnover",nullable = false)
    private Double turnover;

    @Column(name = "create_time",insertable = false, updatable = false, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Column(name = "update_time",insertable = false,  columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
