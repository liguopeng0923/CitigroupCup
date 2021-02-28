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
 * @date 2021/2/27 16:39
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "currencyInfo")
public class CurrencyEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currencyName",nullable = false)
    private String currencyName;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "liquidity",nullable = false)
    private Double liquidity;

    @Column(name = "volume",nullable = false)
    private Double volume;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "priceChange",nullable = false)
    private Double priceChange;

    @Column(name = "create_time",insertable = false, updatable = false, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    @Column(name = "update_time",insertable = false,  columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
