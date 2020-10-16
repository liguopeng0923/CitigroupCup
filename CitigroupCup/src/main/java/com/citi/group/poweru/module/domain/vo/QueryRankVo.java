package com.citi.group.poweru.module.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 15:48
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryRankVo {
    Long userId;
    Integer year;
    List<Integer> months;
}
