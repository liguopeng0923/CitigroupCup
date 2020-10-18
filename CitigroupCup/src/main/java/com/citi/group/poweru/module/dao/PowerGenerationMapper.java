package com.citi.group.poweru.module.dao;

import com.citi.group.poweru.module.domain.entity.DayPower;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/12 23:55
 * @lastEditor
 */
@Mapper
@Repository
public interface PowerGenerationMapper {
    String COLUMNS_1 = "point_id, electric_quantity, upload_time, time_interval";

    String COLUMNS_2 = "record_id, p.point_id, electric_quantity, upload_time, time_interval";

    String PROPS = "#{pointId}, #{electricQuantity}, #{uploadTime,jdbcType=DATE}, #{timeInterval}";

    @Insert("insert into power_generation_info (" + COLUMNS_1 + ") values (" + PROPS + ")")
    @Options(useGeneratedKeys=true, keyProperty="recordId", keyColumn="record_id")
    public void uploadRecord(PowerGenerationRecordEntity powerGenerationRecord);

    @Select("select * from power_generation_info where record_id=#{recordId}")
    public PowerGenerationRecordEntity queryRecordById(Long recordId);

    @Select("select "+COLUMNS_2+" from power_generation_info as p,user_point_relation as r where r.user_id=#{userId}")
    public List<PowerGenerationRecordEntity> queryAllRecordById(long userId);

    @Select("select "+COLUMNS_2+" from power_generation_info as p,user_point_relation as r where r.user_id=#{userId} and upload_time>=#{startTime} and upload_time<=#{endTime}")
    public List<PowerGenerationRecordEntity> queryRecordInPeriodOfTime(@Param("userId")long userId, @Param("startTime")Date startTime,@Param("endTime")Date endTime);

    @Select("SELECT MONTH(upload_time),SUM(electric_quantity) FROM power_generation_info WHERE YEAR(upload_time)=#{year} AND MONTH(upload_time)=#{month} AND DAY(upload_time)=#{day} AND point_id=#{pointId} GROUP BY MONTH(upload_time);")
    @Results(id="generationMap",value = {
            @Result(property = "month",column = "MONTH(upload_time)"),
            @Result(property = "power",column = "SUM(electric_quantity)")
    })
    public DayPower queryDayGeneration(@Param("pointId")long pointId, @Param("year")int year, @Param("month")int month, @Param("day")int day);

    @Select("select sum(electric_quantity) from power_generation_info where point_id=#{pointId}")
    public Double getTotalGenerationPerPoint(@Param("pointId")long pointId);
}
