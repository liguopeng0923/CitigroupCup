package com.citi.group.poweru.module.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/16 21:47
 * @lastEditor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BindVo {
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 基点名称
     */
    private String name;

    /**
     * 基点地址
     */
    private String address;

    /**
     * 激活码
     */
    private String activationCode;
}
