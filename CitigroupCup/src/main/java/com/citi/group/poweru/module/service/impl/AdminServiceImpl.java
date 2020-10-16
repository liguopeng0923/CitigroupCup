package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.dao.RelationMapper;
import com.citi.group.poweru.module.domain.dto.PointInfoDto;
import com.citi.group.poweru.module.service.AdminService;
import com.citi.group.poweru.module.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private UserService userService;

    @Resource
    private RelationMapper relationMapper;

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
        List<PointInfoDto> result = new ArrayList<PointInfoDto>();
        List<Long> userIdList = relationMapper.queryUserIdByAdmin(adminId);
        for (long userId:userIdList) {
            result.addAll(userService.queryPointsInfoByUser(userId));
        }
        return result;
    }
}
