package com.citi.group.poweru.module.service;

import com.citi.group.poweru.module.domain.dto.PointInfoDto;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/13 10:55
 * @lastEditor
 */
public interface AdminService {
    public List<String> queryUserNameByAdmin(Long adminId);

    public List<PointInfoDto> queryPointInfoByAdmin(Long adminId);
}
