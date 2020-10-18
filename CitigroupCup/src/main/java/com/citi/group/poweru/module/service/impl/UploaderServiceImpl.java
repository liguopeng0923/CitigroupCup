package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.PointMapper;
import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;
import com.citi.group.poweru.module.service.UploaderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/14 16:32
 * @lastEditor
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class UploaderServiceImpl implements UploaderService {
    @Resource
    private PowerGenerationMapper generationMapper;

    @Resource
    private PointMapper pointMapper;

    /**
     * 上传发电记录
     * @param powerGenerationRecord 本次发电记录的信息
     */
    @Override
    public PowerGenerationRecordDto uploadRecord(PowerGenerationRecordVo powerGenerationRecord) {
        PowerGenerationRecordEntity record = new PowerGenerationRecordEntity();
        record.setElectricQuantity(powerGenerationRecord.getElectricQuantity());
        record.setPointId(powerGenerationRecord.getPointId());
        record.setTimeInterval(powerGenerationRecord.getTimeInterval());
        record.setUploadTime(powerGenerationRecord.getUploadTime());
        //上传记录
        generationMapper.uploadRecord(record);
        //更新基点状态
        pointMapper.updatePointTime(powerGenerationRecord.getUploadTime(),powerGenerationRecord.getPointId());

        System.out.println(record);
        PowerGenerationRecordEntity checkRecord = generationMapper.queryRecordById(record.getRecordId());
        System.out.println(checkRecord);
        PowerGenerationRecordDto generationRecordDto = new PowerGenerationRecordDto();
        generationRecordDto.setElectricQuantity(checkRecord.getElectricQuantity());
        generationRecordDto.setPointId(checkRecord.getPointId());
        generationRecordDto.setUploadTime(checkRecord.getUploadTime());
        return generationRecordDto;
    }
}
