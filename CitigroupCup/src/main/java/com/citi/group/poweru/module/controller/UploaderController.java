package com.citi.group.poweru.module.controller;

import com.citi.group.poweru.common.domain.ResponseDTO;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;
import com.citi.group.poweru.module.service.UploaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/17 20:47
 * @lastEditor
 */
@RestController
@RequestMapping("/uploader")
@Slf4j
public class UploaderController {
    @Resource
    private UploaderService uploaderService;

    /**
     * 上传发电记录
     * @param powerGenerationRecord 发电记录信息，包括基站id，发电量，上传时间和时间间隔
     * @return 发电记录信息
     */
    @PostMapping("/upload")
    public ResponseDTO<PowerGenerationRecordDto> uploadGenerationRecord(@RequestBody @Valid PowerGenerationRecordVo powerGenerationRecord){
        log.info("UploaderController.uploadGenerationRecord PowerGenerationRecordVo:{}", powerGenerationRecord);
        PowerGenerationRecordDto powerGenerationRecordDto = uploaderService.uploadRecord(powerGenerationRecord);
        return ResponseDTO.successData(powerGenerationRecordDto);
    }
}
