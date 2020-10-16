package com.citi.group.poweru.module.dao;


import com.citi.group.poweru.module.domain.entity.UserEntity;

import com.citi.group.poweru.module.domain.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 16:59
 */
@Mapper
@Repository
public interface UserMapper {

    String COLUMNS = "name, real_name, information, card_id, address, contact_name, email, phone, " +
            "access, credit, profit, gender, birthday, photo, password";
    String PROPS = "#{name}, #{realName}, #{information}, #{cardId}, #{address}, #{contactName}, #{email}, #{phone}, " +
            "#{access}, #{credit}, #{profit}, #{gender}, #{birthday}, #{photo}, #{password}";

    @Insert("insert into user (" +COLUMNS+ ") values (" +PROPS+ ")")
    void insertUser(UserEntity userEntity);

    @Select("select * from user where phone = #{phone} and password = #{password}")
    UserEntity selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    @Select("select * from user where name=#{name}")
    public UserEntity selectUserByName(String name);
}
