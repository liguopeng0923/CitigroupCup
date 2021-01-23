package com.citigroup.whuamm.module.domain.mapper;

import com.alibaba.fastjson.JSONArray;
import com.citigroup.whuamm.module.domain.bo.User;
import com.citigroup.whuamm.module.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 17:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostMapper {

    @NotBlank(message = "昵称不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "性别不能为空")
    private UserEntity.Gender gender;

    @NotBlank(message = "生日不能为空")
    private Date birthday;

    @NotBlank(message = "用户名不能为空")
    private String realName;

    @NotBlank(message = "个人介绍信息不能为空")
    private String information;

    @NotBlank(message = "身份证不能为空")
    private String cardId;

    @NotBlank(message = "籍贯不能为空")
    private String address;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @NotBlank(message = "头像不能为空")
    private String photo;




    public User build()
    {
        return User.builder()
                .id(UUID.randomUUID().toString().replace("-","").toUpperCase().substring(0,32))
                .access(0)
                .address(this.address)
                .birthday(this.birthday)
                .cardId(this.cardId)
                .email(this.email)
                .gender(this.gender)
                .information(this.information)
                .name(this.name)
                .password(this.password)
                .phone(this.phone)
                .photo(this.photo)
                .realName(this.realName)
                .build();

    }
}
