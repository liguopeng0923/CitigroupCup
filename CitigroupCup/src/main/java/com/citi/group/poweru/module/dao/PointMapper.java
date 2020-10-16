package com.citi.group.poweru.module.dao;

import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 23:04
 * @lastEditor
 */
@Mapper
@Repository
public interface PointMapper {
    @Select("select * from point_info where point_id=#{pointId}")
    public PointInfoEntity queryPointInfo(@Param("pointId")Long pointId);

    @Update("update point_info set update_time=#{updateTime} where point_id=#{pointId}")
    public void updatePointTime(@Param("updateTime")String  updateTime, @Param("pointId")Long pointId);
}
