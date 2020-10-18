package com.citi.group.poweru.module.dao;

import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import org.apache.ibatis.annotations.*;
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

    @Update("update point_info set upload_time=#{uploadTime} where point_id=#{pointId}")
    public void updatePointTime(@Param("uploadTime")String  uploadTime, @Param("pointId")Long pointId);

    @Insert("INSERT INTO point_info (`name`, `address`, `status`, `upload_time`, `machine_id`) VALUES (#{name},#{address},#{status},#{upload_time},#{machineId})")
    @Options(useGeneratedKeys=true, keyProperty="pointId", keyColumn="point_id")
    public void insertPoint(PointInfoEntity pointInfoEntity);

    @Select("select point_id from point_info where machine_id=#{machineId}")
    public Long queryPointByMachineId(Long machineId);
}
