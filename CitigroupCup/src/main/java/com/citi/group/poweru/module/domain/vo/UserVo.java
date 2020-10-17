package com.citi.group.poweru.module.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 返回前端用户信息
 */

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 18:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {

    private Long id;
    /**
     * 昵称
     */
    private String name;

    /**
     * 性别
     * 0--男
     * 1--女
     * 2--保密
     */
    private Integer gender;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 个人用户真实名或者企业法人姓名
     */
    private String realName;

    /**
     * 个人或者企业注册信息
     */
    private String information;

    /**
     * 使用者身份证号或者港澳台通行证号
     */
    private String cardId;

    /**
     * 详细地址
     */
    private String address;

    /**
     *企业联系人姓名
     * 如果是企业（电厂级用户），需要输入企业的联系人姓名
     */
    private String contactName;

    /**
     *email
     */
    private String email;

    /**
     *手机号
     */
    private String phone;

    /**
     *头像url
     */
    private String photo;

    /**
     *信用
     * 通过在平台的交易量和年限，包括个人信用信息进行评级，包括0-100
     */
    private Integer credit;

    /**
     *收益
     */
    private Double profit;

}
