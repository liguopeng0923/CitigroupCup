package com.citi.group.poweru.module.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.citi.group.poweru.module.domain.entity.UserEntity;

import com.citi.group.poweru.module.domain.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 16:59
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    String COLUMNS = "name, real_name, information, card_id, address, contact_name, email, phone, " +
            "access, credit, profit, gender, birthday, photo, password";
    String PROPS = "#{name}, #{realName}, #{information}, #{cardId}, #{address}, #{contactName}, #{email}, #{phone}, " +
            "#{access}, #{credit}, #{profit}, #{gender}, #{birthday}, #{photo}, #{password}";

    @Select("select * from user where id = #{id}")
    UserEntity selectById(Long id);

    @Select("select * from user where phone = #{phone}")
    UserEntity selectByPhone(String phone);

    @Select("select * from user where email = #{email}")
    UserEntity selectByEmail(String email);

    @Insert("insert into user (" +COLUMNS+ ") values (" +PROPS+ ")")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertUser(UserEntity userEntity);

    @Select("select * from user where phone = #{phone} and password = #{password}")
    UserEntity selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    @Select("select * from user where email = #{email} and password = #{password}")
    UserEntity selectByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Select("select real_name from user where id=#{userId}")
    String getUserName(Long userId);
}
