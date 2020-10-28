package com.citi.group.poweru.module.service.impl;

import com.citi.group.poweru.module.dao.FeedbackMapper;
import com.citi.group.poweru.module.dao.UserMapper;
import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;
import com.citi.group.poweru.module.service.FeedbackService;
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
        if (Objects.isNull(feedbackVo)){
            String errorInfo = "Feedback_id为" + feedbackVo.toString() + "的反馈不存在，请检查";
            throw new Exception(errorInfo);
        } else{
            return feedbackVo;
        }
    }

    @Override
    public void addFeedback(FeedbackVo feedbackVo) throws Exception {
        if(!Objects.isNull(feedbackVo)) {
            feedbackMapper.addFeedback(feedbackVo);
        }else{
            String errorInfo = "Feedback:"+ feedbackVo.toString()+"插入失败";
            throw new Exception(errorInfo);
        }
    }

    @Override
    public void updateFeedbackSolution(FeedbackInfoDto feedbackInfoDto) throws Exception {
        if (!Objects.isNull(feedbackInfoDto)){
            feedbackMapper.updateFeedbackSolution(feedbackInfoDto);
        }else{
            String errorInfo = "Feedback:"+ feedbackInfoDto.toString()+"更新solution失败";
            throw new Exception(errorInfo);
        }
    }
    @Override
    public void updateFeedbackDetail(FeedbackInfoDto feedbackInfoDto) throws Exception {
        if (!Objects.isNull(feedbackInfoDto)){
            feedbackMapper.updateFeedbackDetail(feedbackInfoDto);
        }else{
            String errorInfo = "Feedback:"+ feedbackInfoDto.toString()+"更新反馈信息失败";
            throw new Exception(errorInfo);
        }
    }

    @Override
    public void deleteFeedbackById(int feedbackId) throws Exception {
        FeedbackVo feedbackVo = queryFeedbackByFeedbackId(feedbackId);
        if (!Objects.isNull(feedbackVo)){
            feedbackMapper.deleteFeedbackById(feedbackId);
        }else {
            String errorInfo = "feedbackId:"+ feedbackId+"对应的feedback不存在";
            throw new Exception(errorInfo);
        }
    }

}
