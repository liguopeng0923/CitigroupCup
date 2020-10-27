package com.citi.group.poweru.module.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/14 16:37
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerGenerationRecordVo {
    /**
     * 发电基点编号
     */
    private Long pointId;

    /**
     * 单次记录发电量
     */
    private Double electricQuantity;

    /**
     * 数据上传时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String  uploadTime;

    /**
     * 本次发电时间间隔
     */
    private Integer timeInterval;
}
