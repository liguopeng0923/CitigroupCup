package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.common.exception.BusinessException;
import com.citi.group.poweru.module.dao.*;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.dto.QueryRankDto;
import com.citi.group.poweru.module.domain.entity.DayPower;
import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.entity.UserEntity;
import com.citi.group.poweru.module.domain.vo.BindVo;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import com.citi.group.poweru.module.domain.vo.RegisterVo;
import com.citi.group.poweru.module.domain.vo.UserVo;
import com.citi.group.poweru.module.service.UserService;
import com.citi.group.poweru.util.StatisticalUtil;
import org.apache.tomcat.jni.User;
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
    private MachineMapper machineMapper;

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

        if(!Objects.isNull(userMapper.selectByPhone(registerVo.getPhone()))){
            throw new BusinessException("该手机号已被注册");
        }
        if(!Objects.isNull(userMapper.selectByEmail(registerVo.getEmail()))){
            throw new BusinessException("该邮箱已被注册");
        }
        UserEntity userEntity = UserEntity.builder()
                .phone(registerVo.getPhone())
                .email(registerVo.getEmail())
                .password(registerVo.getPassword())
                .access(0)
                .build();
        userMapper.insertUser(userEntity);

        UserVo userVo = userMapper.selectById(userEntity.getId());

        return UserVo.builder()
                .email(userVo.getEmail())
                .phone(userVo.getPhone())
                .access(userVo.getAccess())
                .build();
    }

    @Override
    public UserVo login(String loginNumber, String password) {
        UserVo userVo;
        if(loginNumber.contains("@")){
            userVo = userMapper.selectByEmailAndPassword(loginNumber, password);
        }else{
            userVo = userMapper.selectByPhoneAndPassword(loginNumber, password);
        }
        if(Objects.nonNull(userVo)){
            return UserVo.builder()
                    .id(userVo.getId())
                    .phone(userVo.getPhone())
                    .address(userVo.getAddress())
                    .birthday(userVo.getBirthday())
                    .access(userVo.getAccess())
                    .cardId(userVo.getCardId())
                    .contactName(userVo.getContactName())
                    .credit(userVo.getCredit())
                    .email(userVo.getEmail())
                    .gender(userVo.getGender())
                    .information(userVo.getInformation())
                    .name(userVo.getName())
                    .photo(userVo.getPhoto())
                    .profit(userVo.getProfit())
                    .realName(userVo.getRealName())
                    .build();
        }
        throw new BusinessException("用户名或密码错误");
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
        List<QueryRankDto> result = new ArrayList<>();
        //存放每天发电量,key代表日期,value表示发电量
        Map<Integer, Double> generationPerDay;
        //存放用户对应的发电基站
        List<Long> pointIdList = relationMapper.queryPointIdByUser(queryRankVo.getUserId());

        //查询发电量数据
        for(int month = 1;month<=12;month++) {
            generationPerDay = new  HashMap<>(31);
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
            //本月未发电则所有信息为0
            if(generationPerDay.isEmpty()){
                dto.setMin(0.0);
                dto.setMinDay(0);
                dto.setMax(0.0);
                dto.setMaxDay(0);
                dto.setAverage(0.0);
            }
            else {
                Map.Entry<Integer, Double> entry = StatisticalUtil.getMax(generationPerDay);
                //设置最大值和对应的日期
                dto.setMaxDay(entry.getKey());
                dto.setMax(entry.getValue());
                entry = StatisticalUtil.getMin(generationPerDay);
                //设置最大值和对应的日期
                dto.setMinDay(entry.getKey());
                dto.setMin(entry.getValue());
                //设置平均值
                Integer daysOfMonth = StatisticalUtil.getDaysOfMonth(queryRankVo.getYear(), month);
                dto.setAverage(StatisticalUtil.getAverage(generationPerDay, daysOfMonth));
            }
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
            if(Objects.isNull(infoEntity)){
                throw new BusinessException("基点绑定信息有误，请重新绑定");
            }
            dto.setName(infoEntity.getName());
            dto.setAddress(infoEntity.getAddress());
            if(Objects.isNull(generationMapper.getTotalGenerationPerPoint(id))){
                dto.setTotalGeneration(0.0);
            }
            else {
                dto.setTotalGeneration(generationMapper.getTotalGenerationPerPoint(id));
            }
            dto.setStatus(infoEntity.getStatus());
            if(!Objects.isNull(infoEntity.getUpload_time())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dto.setUploadTime(sdf.format(infoEntity.getUpload_time()));
            }
            result.add(dto);
        }
        return result;
    }


    /**
     * 绑定用户和基点
     * @param bindVo 绑定信息
     */
    @Override
    public PointInfoDto userBindPoint(BindVo bindVo){
        Long machineId = machineMapper.selectMachineId(bindVo.getActivationCode());
        //检查当前机器是否已绑定
        if(Objects.isNull(pointMapper.queryPointByMachineId(machineId))){
            throw new BusinessException("当前机器已绑定，请确认激活码是否无误");
        }
        PointInfoEntity pointInfoEntity = new PointInfoEntity();
        pointInfoEntity.setName(bindVo.getName());
        pointInfoEntity.setStatus("关闭");
        pointInfoEntity.setMachineId(machineId);
        pointInfoEntity.setAddress(bindVo.getAddress());
        pointMapper.insertPoint(pointInfoEntity);
        relationMapper.insertUserAndPointRelation(bindVo.getUserId(),pointInfoEntity.getPointId());
        //检查插入是否成功
        PointInfoEntity checkInfo = pointMapper.queryPointInfo(pointInfoEntity.getPointId());
        if(Objects.isNull(checkInfo)){
            throw new BusinessException("绑定失败");
        }
        PointInfoDto pointInfoDto = new PointInfoDto();
        pointInfoDto.setAddress(checkInfo.getAddress());
        pointInfoDto.setName(checkInfo.getName());
        pointInfoDto.setStatus(checkInfo.getStatus());
        pointInfoDto.setTotalGeneration(0.0);
        return pointInfoDto;
    }

}
