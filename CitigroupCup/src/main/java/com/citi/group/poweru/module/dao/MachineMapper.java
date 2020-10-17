package com.citi.group.poweru.module.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/16 21:53
 * @lastEditor
 */
@Mapper
@Repository
public interface MachineMapper {
    @Select("select machine_id from machine_relation where activation_code=#{activationCode}")
    public Long selectMachineId(String activationCode);
}
