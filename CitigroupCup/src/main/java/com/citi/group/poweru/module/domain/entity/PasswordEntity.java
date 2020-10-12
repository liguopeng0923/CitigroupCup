package com.citi.group.poweru.module.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 17:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "password")
public class PasswordEntity {
    @TableId(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;


    @TableField(value = "standby1")
    private String standby1;

    @TableField(value = "standby2")
    private String standby2;

}
