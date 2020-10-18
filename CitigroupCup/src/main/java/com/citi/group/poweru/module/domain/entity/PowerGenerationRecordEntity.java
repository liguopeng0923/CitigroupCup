package com.citi.group.poweru.module.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/12 23:39
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "power_generation_info")
public class PowerGenerationRecordEntity {
    @TableId(value = "record_id")
    private Long recordId;

    /**
     * 发电基点编号
     */
    @TableField(value = "point_id")
    private Long pointId;

    /**
     * 单次记录发电量
     */
    @TableField(value = "electric_quantity")
    private Double electricQuantity;

    /**
     * 数据上传时间
     */
    @TableField(value = "upload_time")
    private String uploadTime;

    /**
     * 本次发电时间间隔
     */
    @TableField(value = "time_interval")
    private Integer timeInterval;
}
