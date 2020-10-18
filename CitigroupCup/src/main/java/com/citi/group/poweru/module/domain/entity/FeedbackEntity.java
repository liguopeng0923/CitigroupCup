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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "feedback_info")
public class FeedbackEntity {
    /**
     * 反馈信息的标识
     */
    @TableId(value = "feedback_id")
    private int feedbackId;
    /**
     * 反馈者标识
     */
    @TableField(value = "user_id")
    private int userId;
    /**
     * 反馈内容是否解决
     */
    @TableField(value = "solution")
    private int solute;
    /**
     * 反馈内容
     */
    @TableField(value = "information")
    private String feedbackInfo;
    /**
     * 建立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @TableField(value = "update_time")
    private Date updateTime;
    @TableField(value = "deleted")
    private String deleted;
    @TableField(value = "standby2")
    private String standBy2;
    @TableField(value = "standby3")
    private String standBy3;
}
