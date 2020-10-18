package com.citi.group.poweru.module.dao;


import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    @Select("select feedback_id, user_id, solution, information, create_time from feedback_info where feedback_id=#{feedback_id}")
    @Results(value = {
            @Result(property = "feedbackId", column = "feedback_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "solution", column = "solution"),
            @Result(property = "feedbackInfo", column = "information"),
            @Result(property = "createTime", column = "create_time"),
    })
    public FeedbackVo selectByFeedbackId(int FeedbackId);
    @Select("select feedback_id from feedback_info where user_id=#{user_id}")
    public List<Integer> selectFeedbackIdByUserId(int user_id);

}
