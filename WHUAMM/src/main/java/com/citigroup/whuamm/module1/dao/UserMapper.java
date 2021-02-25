package com.citigroup.whuamm.module1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.citi.group.whuamm.module.domain.entity.UserEntity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 16:59
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    String COLUMNS = "name, real_name, information, card_id, address, contact_name, email, phone, " +
            "access, credit, balance, gender, birthday, photo, password";
    String PROPS = "#{name}, #{realName}, #{information}, #{cardId}, #{address}, #{contactName}, #{email}, #{phone}, " +
            "#{access}, #{credit}, #{balance}, #{gender}, #{birthday}, #{photo}, #{password}";

    @Insert("insert into user (" + COLUMNS + ") values (" + PROPS + ")")
    void insertUser(UserEntity userEntity);

    @Select("select * from user where phone = #{phone} and password = #{password}")
    UserEntity selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);
}
