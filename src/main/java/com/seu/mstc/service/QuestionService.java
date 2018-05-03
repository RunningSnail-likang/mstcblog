package com.seu.mstc.service;

import com.seu.mstc.model.Question;
import com.seu.mstc.result.ResultInfo;

/**
 * Created by lk on 2018/5/3.
 */
public interface QuestionService {

    public ResultInfo addQuestion(int userId, Question question);//发布技术讨论帖

}
