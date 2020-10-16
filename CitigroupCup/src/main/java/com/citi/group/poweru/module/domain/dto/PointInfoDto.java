package com.citi.group.poweru.module.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 23:33
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointInfoDto {
    /**
     * 基点编号
     */
    private Long pointId;

    /**
     * 基点总发电量
     */
    private Double totalGeneration;

    /**
     * 基点状态
     */
    private String status;

    /**
     * 基点信息上一次更新时间
     */

    private String updateTime;
}
