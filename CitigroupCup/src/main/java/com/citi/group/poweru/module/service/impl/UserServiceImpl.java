package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.PointMapper;
import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.dao.RelationMapper;
import com.citi.group.poweru.module.dao.UserMapper;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.dto.QueryRankDto;
import com.citi.group.poweru.module.domain.entity.DayPower;
import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.entity.UserEntity;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;
import com.citi.group.poweru.module.service.UserService;
import com.citi.group.poweru.util.StatisticalUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2020/10/12 19:07
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PowerGenerationMapper generationMapper;

    @Resource
    private RelationMapper relationMapper;

    @Resource
    private PointMapper pointMapper;

    private List<PowerGenerationRecordDto> generationRecordDtoList=new ArrayList<PowerGenerationRecordDto>();;

    @Override
    public UserVo register(RegisterVo registerVo) {
        UserEntity userEntity = UserEntity.builder()
                .name(registerVo.getNickname())
                .phone(registerVo.getLoginNumber())
                .password(registerVo.getPassword())
                .access(0)
                .build();
        userMapper.insertUser(userEntity);

        return UserVo.builder()
                .phone(userEntity.getPhone())
                .id(userEntity.getId()).build();
    }

    @Override
    public UserVo login(String loginNumber, String password) {
//        UserEntity userEntity = userMapper.selectByPhoneAndPassword(loginNumber, password);
//        if(Objects.nonNull(userEntity)){
//            return UserVo.builder()
//                    .id()
//                    .phone()
//                    .address()
//                    .birthday()
//                    .cardId()
//                    .contactName()
//                    .credit()
//                    .email()
//                    .gender()
//                    .information()
//                    .name()
//                    .photo()
//                    .profit()
//                    .realName()
//                    .build()
//        }
        return null;
    }

    /**
     * 获取当前用户所有发电记录
     * @param userId 用户id
     * @return 发电记录列表
     */
    @Override
    public List<PowerGenerationRecordDto> queryAllRecordById(Long userId) {
        //generationRecordDtoList = new ArrayList<PowerGenerationRecordDto>();
        List<PowerGenerationRecordEntity> generationRecords = generationMapper.queryAllRecordById(userId);
        for (PowerGenerationRecordEntity entity:generationRecords){
            generationRecordDtoList.add(new PowerGenerationRecordDto(entity.getPointId(),entity.getElectricQuantity(),entity.getUploadTime()));
        }
        return generationRecordDtoList;
    }

    /**
     * 获取当前用户一段时间内发电记录
     * @param userId 用户id
     * @return 发电记录列表
     */
    @Override
    public List<PowerGenerationRecordDto> queryRecordInPeriodOfTime(Long userId, Date startTime, Date endTime) {
        //generationRecordDtoList = new ArrayList<PowerGenerationRecordDto>();
        List<PowerGenerationRecordEntity> generationRecords = generationMapper.queryRecordInPeriodOfTime(userId,startTime,endTime);
        for (PowerGenerationRecordEntity entity:generationRecords){
            generationRecordDtoList.add(new PowerGenerationRecordDto(entity.getPointId(),entity.getElectricQuantity(),entity.getUploadTime()));
        }
        return generationRecordDtoList;
    }

    /**
     * 查询一年中每月的日发电量的统计数据（最大值，最小值，平均值）
     * @param queryRankVo 前端传来的查询信息
     * @return 每个月的统计数据列表
     */
    @Override
    public List<QueryRankDto> queryStatisticalDataOfMonthGeneration(QueryRankVo queryRankVo) {
        //存放结果
        List<QueryRankDto> result = new ArrayList<QueryRankDto>();
        //存放每天发电量
        Map<Integer, Double> generationPerDay;
        //存放用户对应的发电基站
        List<Long> pointIdList = relationMapper.queryPointIdByUser(queryRankVo.getUserId());
        //获取用户需要查询的月份
        List<Integer> months = queryRankVo.getMonths();

        //查询发电量数据
        for(Integer month:months) {
            generationPerDay = new  HashMap<Integer,Double>();
            for (int i = 1; i <= 31; i++) {
                //用户每天发电
                Double dayGenerationOfUser = 0.0;
                for (long id : pointIdList) {
                    DayPower dayPower = generationMapper.queryDayGeneration(id, queryRankVo.getYear(), month, i);
                    if (dayPower != null) {
                        dayGenerationOfUser += dayPower.getPower();
                    }
                }
                if(dayGenerationOfUser>0.0)
                {
                    generationPerDay.put(i, dayGenerationOfUser);
                }
            }
            QueryRankDto dto=new QueryRankDto();
            //设置当前查询月份
            dto.setMonth(month);
            Map.Entry<Integer,Double> entry = StatisticalUtil.getMax(generationPerDay);
            //设置最大值和对应的日期
            dto.setMaxDay(entry.getKey());
            dto.setMax(entry.getValue());
            entry = StatisticalUtil.getMin(generationPerDay);
            //设置最大值和对应的日期
            dto.setMinDay(entry.getKey());
            dto.setMin(entry.getValue());
            //设置平均值
            Integer daysOfMonth = StatisticalUtil.getDaysOfMonth(queryRankVo.getYear(),month);
            dto.setAverage(StatisticalUtil.getAverage(generationPerDay,daysOfMonth));
            result.add(dto);
        }
        return result;
    }


    /**
     * 查询用户名下的所有基点信息
     * @param userId 用户编号
     * @return 基点信息列表
     */
    @Override
    public List<PointInfoDto> queryPointsInfoByUser(Long userId){
        List<PointInfoDto> result = new ArrayList<PointInfoDto>();
        List<Long> pointIdList = relationMapper.queryPointIdByUser(userId);
        for (long id:pointIdList){
            PointInfoDto dto = new PointInfoDto();
            PointInfoEntity infoEntity = pointMapper.queryPointInfo(id);
            dto.setPointId(id);
            dto.setTotalGeneration(generationMapper.getTotalGenerationPerPoint(id));
            dto.setStatus(infoEntity.getStatus());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dto.setUpdateTime(sdf.format(infoEntity.getUpdate_time()));
            result.add(dto);
        }
        return result;
    }

}
