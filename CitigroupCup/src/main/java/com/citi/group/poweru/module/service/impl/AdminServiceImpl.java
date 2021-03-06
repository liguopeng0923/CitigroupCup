package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.common.exception.BusinessException;
import com.citi.group.poweru.module.dao.PointMapper;
import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.dao.RelationMapper;
import com.citi.group.poweru.module.dao.UserMapper;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import com.citi.group.poweru.module.service.AdminService;
import com.citi.group.poweru.module.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/13 11:04
 * @lastEditor
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class AdminServiceImpl implements AdminService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RelationMapper relationMapper;

    @Resource
    private PointMapper pointMapper;

    @Resource
    private PowerGenerationMapper powerGenerationMapper;

    @Override
    public List<String> queryUserNameByAdmin(Long adminId) {
        return relationMapper.queryRealNameByAdmin(adminId);
    }

    /**
     * 管理员查询基点信息
     * @param adminId 管理员id
     * @return 基点信息列表
     */
    @Override
    public List<PointInfoDto> queryPointInfoByAdmin(Long adminId) {
        List<PointInfoDto> result = new ArrayList<>();
        List<Long> userIdList = relationMapper.queryUserIdByAdmin(adminId);
        for (long userId:userIdList) {
            List<Long> pointIdList = relationMapper.queryPointIdByUser(userId);
            String userName = userMapper.getUserName(userId);
            for (long pointId:pointIdList){
                PointInfoDto dto = new PointInfoDto();
                PointInfoEntity infoEntity = pointMapper.queryPointInfo(pointId);
                if(Objects.isNull(infoEntity)){
                    throw new BusinessException("用户基点绑定信息有误，请检查");
                }
                dto.setName(infoEntity.getName());
                dto.setUserName(userName);
                dto.setAddress(infoEntity.getAddress());
                if(Objects.isNull(powerGenerationMapper.getTotalGenerationPerPoint(pointId))){
                    dto.setTotalGeneration(0.0);
                }
                else {
                    dto.setTotalGeneration(powerGenerationMapper.getTotalGenerationPerPoint(pointId));
                }
                dto.setStatus(infoEntity.getStatus());
                if(!Objects.isNull(infoEntity.getUpload_time())){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dto.setUploadTime(sdf.format(infoEntity.getUpload_time()));
                }
                result.add(dto);
            }
        }
        return result;
    }
}
