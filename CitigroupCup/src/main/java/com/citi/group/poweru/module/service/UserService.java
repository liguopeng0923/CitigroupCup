package com.citi.group.poweru.module.service;

import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.dto.QueryRankDto;
import com.citi.group.poweru.module.domain.vo.BindVo;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;

import java.util.Date;
import java.util.List;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 18:57
 */

public interface UserService {
    UserVo register(RegisterVo registerVo);
    UserVo login(String loginNumber, String password);

    List<PowerGenerationRecordDto> queryAllRecordById(Long userId);

    List<PowerGenerationRecordDto> queryRecordInPeriodOfTime(Long userId, Date startTime, Date endTime);

    List<QueryRankDto> queryStatisticalDataOfMonthGeneration(QueryRankVo queryRankVo);

    List<PointInfoDto> queryPointsInfoByUser(Long userId);

    PointInfoDto userBindPoint(BindVo bindVo);
}
