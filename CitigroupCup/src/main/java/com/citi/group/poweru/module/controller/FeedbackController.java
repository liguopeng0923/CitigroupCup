package com.citi.group.poweru.module.controller;


import com.citi.group.poweru.common.domain.ResponseDTO;
import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;
import com.citi.group.poweru.module.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feedback")
@Slf4j
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @GetMapping("/queryFeedbackIdByUserId")
    public ResponseDTO<List<Integer>> queryFeedbackIdByUserId(@RequestParam("userId") @Valid int userId) throws Exception {
        log.info("FeedbackController.queryFeedbackIdByUserId userId:{}", userId);
        List<Integer> pointInfos = feedbackService.queryPointInfoByUser(userId);
        return ResponseDTO.successData(pointInfos);
    }
    @GetMapping("/queryFeedbackById")
    public ResponseDTO<FeedbackVo> queryFeedbackById(@RequestParam("feedbackId") @Valid int feedbackId) throws Exception {
        log.info("FeedbackController.queryFeedbackById feedbackId:{}", feedbackId);
        FeedbackVo feedbackVo = feedbackService.queryFeedbackByFeedbackId(feedbackId);
        return ResponseDTO.successData(feedbackVo);
    }
    @PostMapping("/addFeedback")
    public ResponseDTO<FeedbackVo> addFeedback(@RequestBody @Valid FeedbackVo feedbackVo) throws Exception {
        log.info("FeedbackController.addFeedback FeedbackVo:{}", feedbackVo);
        feedbackService.addFeedback(feedbackVo);
        return ResponseDTO.successData(feedbackVo);
    }



}
