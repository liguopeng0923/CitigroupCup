package com.citi.group.poweru.module.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 15:19
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayPower {
    /**
     * 所在月份
     */
    private Integer month;

    /**
     * 当日发电量
     */
    private Double power;
}
