package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.common.exception.BusinessException;
import com.citi.group.poweru.module.dao.PointMapper;
import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;
import com.citi.group.poweru.module.service.UploaderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
        //检查日期格式是否正确
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate;
        try {
            newDate = sdf.parse(powerGenerationRecord.getUploadTime());
        }
        catch (ParseException e){
            throw new BusinessException("上传记录日期格式错误失败，请按照'yyyy-MM-dd HH:mm:ss'上传");
        }
        PowerGenerationRecordEntity record = new PowerGenerationRecordEntity();
        record.setElectricQuantity(powerGenerationRecord.getElectricQuantity());
        record.setPointId(powerGenerationRecord.getPointId());
        record.setTimeInterval(powerGenerationRecord.getTimeInterval());
        record.setUploadTime(powerGenerationRecord.getUploadTime());
        //上传记录
        generationMapper.uploadRecord(record);
        PowerGenerationRecordEntity checkRecord = generationMapper.queryRecordById(record.getRecordId());
        //检查是否上传成功
        if(Objects.isNull(checkRecord)) {
            throw new BusinessException("上传记录失败");
        }

        //本次上传记录时间与上一次基点更新的间隔和标准间隔不一致（超过误差范围）时显示状态异常
        Date oldDate = pointMapper.queryPointUploadTime(powerGenerationRecord.getPointId());
        //如果之前未上传过记录
        if(Objects.isNull(oldDate)){
            pointMapper.updatePointStatus(powerGenerationRecord.getPointId(),"正常");
        }
        else {
            //毫秒为单位
            long inaccurate = (newDate.getTime() - oldDate.getTime()) - powerGenerationRecord.getTimeInterval() * 3600000;
            if (inaccurate < 5000 && inaccurate > -5000) {
                //更新基点状态为正常
                pointMapper.updatePointStatus(powerGenerationRecord.getPointId(), "正常");
            } else {
                //超出误差，更新基点状态为异常
                pointMapper.updatePointStatus(powerGenerationRecord.getPointId(), "异常");
            }
        }
        //更新基点时间
        pointMapper.updatePointTime(powerGenerationRecord.getUploadTime(),powerGenerationRecord.getPointId());
        PowerGenerationRecordDto generationRecordDto = new PowerGenerationRecordDto();
        generationRecordDto.setElectricQuantity(checkRecord.getElectricQuantity());
        generationRecordDto.setPointId(checkRecord.getPointId());
        generationRecordDto.setUploadTime(checkRecord.getUploadTime());
        return generationRecordDto;
    }
}
