package com.citi.group.whuamm.module.domain.entity;

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
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 性别
     * 0--男
     * 1--女
     * 2--保密
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 出生年月
     */
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

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
     * 企业联系人姓名
     * 如果是企业（电厂级用户），需要输入企业的联系人姓名
     */
    @TableField(value = "contact_name")
    private String contactName;

    /**
     * email
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 头像url
     */
    @TableField(value = "photo")
    private String photo;

    /**
     * 信用
     * 通过在平台的交易量和年限，包括个人信用信息进行评级，包括0-100
     */
    @TableField(value = "credit")
    private Integer credit;

    /**
     * 账户余额
     */
    @TableField(value = "balance")
    private Double balance;

    /**
     * 权限
     * 用户权限分为三种，0级权限为普通用户，1级权限为管理员，2级权限为超级管理员
     */
    @TableField(value = "access")
    private Integer access;


    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableField(value = "standby1")
    private String standby1;

    @TableField(value = "standby2")
    private String standby2;

    @TableField(value = "standby3")
    private String standby3;
}
