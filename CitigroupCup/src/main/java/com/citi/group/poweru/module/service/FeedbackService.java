package com.citi.group.poweru.module.service;

import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;

import java.util.List;

public interface FeedbackService {

    List<Integer> queryPointInfoByUser(int userId) throws Exception;
    FeedbackVo queryFeedbackByFeedbackId(int feedbackId) throws Exception;
}
