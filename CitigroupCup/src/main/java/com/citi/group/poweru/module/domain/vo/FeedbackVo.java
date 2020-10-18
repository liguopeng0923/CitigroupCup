package com.citi.group.poweru.module.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackVo {
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
    private int solution;
    /**
     * 反馈内容
     */
    private String feedbackInfo;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return "FeedbackVo{" +
                "feedbackId=" + feedbackId +
                ", userId=" + userId +
                ", solution=" + solution +
                ", feedbackInfo='" + feedbackInfo + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
