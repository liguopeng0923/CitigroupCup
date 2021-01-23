package com.citigroup.whuamm.module.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.citigroup.whuamm.module.domain.status.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 17:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id",nullable = false)
    private String id;

    /**
     * 昵称
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * 密码
     */
    @Column(name = "password",nullable = false)

    private String password;

    /**
     * 性别
     * 0--男
     * 1--女
     * 2--保密
     */
    @Column(name = "gender",nullable = false)
    private Gender gender;

    public enum Gender {
        MALE,FEMALE,SECRECY
    }

    /**
     * 出生年月
     */
    @Column(name = "birthday",nullable = false)

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 个人用户真实名
     */
    @Column(name = "real_name",nullable = false)
    private String realName;

    /**
     * 个人介绍信息
     */
    @Column(name = "information",nullable = false)
    private String information;

    /**
     * 使用者身份证号或者港澳台通行证号
     */
    @Column(name = "card_id",nullable = false)
    private String cardId;

    /**
     * 详细地址
     */
    @Column(name = "address",nullable = false)
    private String address;

    /**
     * email
     */
    @Column(name = "email",nullable = false)
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone",nullable = false)
    private String phone;

    /**
     * 头像url
     */
    @Column(name = "photo",nullable = false)
    private String photo;



    @Column(name = "status",nullable = false)
    private Status status;
    /**
     * 权限
     */
    @Column(name = "access",nullable = false)
    private Integer access;


    @Column(name = "create_time",insertable = false, updatable = false, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    @Column(name = "update_time",insertable = false,  columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Column(name = "standby1",nullable = false)
    private String standby1;

    @Column(name = "standby2",nullable = false)
    private String standby2;

    @Column(name = "standby3",nullable = false)
    private String standby3;
}

