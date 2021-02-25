package com.citi.group.whuamm.module.domain.vo;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 18:28
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * 此类代表登录注册类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVo {

    //昵称不能为空
    @NotNull(message = "昵称不能为空")
    @Size(max = 32, message = "昵称最多为32个字符")
    private String nickname;

    //账号（手机号）
    @NotNull(message = "账号不能为空")
    @Size(max = 32, message = "账号最多为32个字符")
    private String loginNumber;

    //密码
    @NotBlank(message = "密码不能为空")
    @Min(value = 8, message = "密码最少为8个字符")
    @Max(value = 32, message = "密码最多为32个字符")
    private String password;

}
