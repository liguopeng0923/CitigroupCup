package com.citi.group.poweru.module.domain.vo;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 18:28
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import java.util.Date;

/**
 * 此类代表登录注册类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVo {

    //昵称不能为空
//    @NotNull(message = "昵称不能为空")
//    @Size(max = 32,message = "昵称最多为32个字符")
//    private String nickname;

    //账号（手机号）
    @NotNull(message = "手机号不能为空")
    @Size(max = 11,min = 11,message = "手机号应为11位")
    private String phone;

    //账号（邮箱）
    @NotNull(message = "邮箱不能为空")
    private String email;

    //密码
    @NotBlank(message = "密码不能为空")
    @Min(value = 6, message = "密码最少为8个字符")
    @Max(value = 32, message = "密码最多为32个字符")
    private String password;

}
