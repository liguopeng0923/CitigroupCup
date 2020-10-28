package com.citi.group.poweru.module.dao;


import com.citi.group.poweru.module.domain.dto.FeedbackInfoDto;
import com.citi.group.poweru.module.domain.vo.FeedbackVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    String COLUMNS_1 = "feedback_id, user_id, solution, information, create_time";
    String PROPS = "#{feedbackId}, #{userId}, #{solution}, #{feedbackInfo}, #{createTime,jdbcType=DATE}";
    @Select("select "+ COLUMNS_1 +" from feedback_info where feedback_id=#{feedback_id}")
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
    @Insert("insert into feedback_info ("+COLUMNS_1+") values ("+ PROPS+")")
    @Options(useGeneratedKeys=true, keyProperty="feedbackId", keyColumn="feedback_id")
    public void addFeedback(FeedbackVo feedbackVo);
    @Update("update feedback_info set solution=#{solution}, update_time=#{update_time} where feedback_id=#{feedback_id}")
    public void updateFeedbackSolution(FeedbackInfoDto feedbackInfoDto);
    @Update("update feedback_info set solution=#{solution}, user_id=#{user_id}, information=#{feedbackInfo}, update_time=#{updateTime} where feedback_id=#{feedback_id}")
    public void updateFeedbackDetail(FeedbackInfoDto feedbackInfoDto);
    @Delete("delete from feedback_info where feedback_id=#{feedbackId}")
    void deleteFeedbackById(int feedbackId);
}
