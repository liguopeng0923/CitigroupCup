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
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "user")
public class UserEntity {

    @TableId(value = "id")
    private Long id;

    /**
     * 昵称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 个人用户真实名或者企业法人姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 个人或者企业注册信息
     */
    @TableField(value = "information")
    private String information;

    /**
     * 使用者身份证号或者港澳台通行证号
     */
    @TableField(value = "card_id")
    private String cardId;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     *企业联系人姓名
     * 如果是企业（电厂级用户），需要输入企业的联系人姓名
     */
    @TableField(value = "contact_name")
    private String contactName;

    /**
     *email
     */
    @TableField(value = "email")
    private String email;

    /**
     *手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     *权限
     * 用户权限分为三种，0级权限为普通用户，1级权限为管理员（电厂级用户），2级权限为超级管理员
     */
    @TableField(value = "access")
    private Integer access;

    /**
     *信用
     * 通过在平台的交易量和年限，包括个人信用信息进行评级，包括0-100
     */
    @TableField(value = "credit")
    private Integer credit;

    /**
     *收益
     */
    @TableField(value = "profit")
    private Integer profit;

    @TableField(value = "gmt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @TableField(value = "create_by")
    private String createBy;

    @TableField(value = "gmt_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtUpdate;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(value = "standby1")
    private String standby1;

    @TableField(value = "standby2")
    private String standby2;
}
