package com.citi.group.poweru.module.domain.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/14 14:33
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerGenerationRecordDto {
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
    private String uploadTime;
}
