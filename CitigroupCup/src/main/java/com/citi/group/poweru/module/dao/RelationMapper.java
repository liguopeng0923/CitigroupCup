package com.citi.group.poweru.module.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/13 9:54
 * @lastEditor
 */
@Mapper
@Repository
public interface RelationMapper {
    /**
     * 插入用户id和发电基点id的绑定关系
     * @param userId 用户id
     * @param pointId 发电基点id
     */
    @Insert("insert into user_point_relation (user_id,point_id)values(#{userId},#{pointId})")
    public void insertUserAndPointRelation(@Param("userId") Long userId,@Param("pointId") Long pointId);

    /**
     * 查询当前管理员绑定的所有用户id
     * @param adminId 管理员id
     * @return 用户id列表
     */
    @Select("select user_id from admin_user_relation where admin_id=#{adminId}")
    public List<Long> queryUserIdByAdmin(Long adminId);


    @Select("select real_name from user,admin_user_relation where admin_id=#{adminId}")
    public List<String> queryRealNameByAdmin(Long adminId);

    /**
     * 根据用户id查询发电基点id
     * @param userId 用户id
     * @return 属于该用户的发电基点id列表
     */
    @Select("select point_id from user_point_relation where user_id=#{userId}")
    public List<Long> queryPointIdByUser(Long userId);

}