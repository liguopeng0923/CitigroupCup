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
    private Integer month;
    private Integer maxDay;
    private Double max;
    private Integer minDay;
    private Double min;
    private Double average;
}
