package com.citigroup.whuamm.module.domain.bo;

import com.citigroup.whuamm.module.domain.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.NodeBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 17:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
   
    private String id;
    
    private String name;

    private String password;
    
    private UserEntity.Gender gender;
    
    private Date birthday;
    
    private String realName;
    
    private String information;
    
    private String cardId;

    private String address;

    private String email;

    private String phone;

    private String photo;

    private Integer access;
}
