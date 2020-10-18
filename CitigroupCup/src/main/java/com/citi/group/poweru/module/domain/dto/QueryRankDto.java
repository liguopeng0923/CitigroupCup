package com.citi.group.poweru.module.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 19:29
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryRankDto {
    /**
     * 当前数据所属月份
     */
    private Integer month;

    /**
     * 本月发电量最大日期
     */
    private Integer maxDay;

    /**
     * 本月发电量最大值
     */
    private Double max;

    /**
     * 本月发电量最小日期
     */
    private Integer minDay;

    /**
     * 本月发电量最小值
     */
    private Double min;

    /**
     * 本月发电量平均值
     */
    private Double average;
}
