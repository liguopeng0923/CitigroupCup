package com.citi.group.poweru.module.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackInfoDto {


    /**
     * 反馈信息的标识
     */
    private int feedbackId;
    /**
     * 反馈者标识
     */
    private int userId;
    /**
     * 反馈内容是否解决
     */
    private int solute;
    /**
     * 反馈内容
     */
    private String feedbackInfo;
    /**
     * 建立时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;




}
