package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.FeedbackMapper;
import com.citi.group.poweru.module.dao.UserMapper;
import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.entity.FeedbackEntity;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;
import com.citi.group.poweru.module.service.FeedbackService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class FeedbackImpl implements FeedbackService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Integer> queryPointInfoByUser(int userId) throws Exception {
        List<Integer> result = new ArrayList<>();
        List<Integer> feedbackIdList = feedbackMapper.selectFeedbackIdByUserId(userId);
        for (Integer i:feedbackIdList) {
            FeedbackVo feedbackVo = feedbackMapper.selectByFeedbackId(i);
            System.out.println(i);
            if (Objects.isNull(feedbackVo)) {
                String errorInfo = "Feedback_id为" + i.toString() + "的反馈不存在，请检查";
                throw new Exception(errorInfo);
            } else {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public FeedbackVo queryFeedbackByFeedbackId(int feedbackId) throws Exception {
        FeedbackVo feedbackVo = feedbackMapper.selectByFeedbackId(feedbackId);
        System.out.println(feedbackVo);
        if (Objects.isNull(feedbackVo)){
            String errorInfo = "Feedback_id为" + feedbackVo.toString() + "的反馈不存在，请检查";
            throw new Exception(errorInfo);
        } else{
            return feedbackVo;
        }
    }
}
