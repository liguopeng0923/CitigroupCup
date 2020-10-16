package com.citi.group.poweru.module.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 23:05
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "point_info")
public class PointInfoEntity {

    /**
     * 发电基站编号
     */
    @TableId(value = "point_id")
    private Long point_id;

    /**
     * 基站地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 基站状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 上一次更新时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date update_time;
}
