package com.seu.mstc.service;

import com.seu.mstc.model.Programming;
import com.seu.mstc.result.ResultInfo;

/**
 * Created by lk on 2018/5/3.
 */
public interface ProgrammingService {

    public ResultInfo addProgramming(int userId, Programming programming);//发布编程题目

}
