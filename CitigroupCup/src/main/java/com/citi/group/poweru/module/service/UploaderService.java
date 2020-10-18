package com.citi.group.poweru.module.service;

import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/13 10:52
 * @lastEditor
 */
public interface UploaderService {

    public PowerGenerationRecordDto uploadRecord(PowerGenerationRecordVo powerGenerationRecord);
}
