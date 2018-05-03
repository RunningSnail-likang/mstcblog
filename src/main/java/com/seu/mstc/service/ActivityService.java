package com.seu.mstc.service;

import com.seu.mstc.model.Activity;
import com.seu.mstc.result.ResultInfo;

/**
 * Created by lk on 2018/5/3.
 */
public interface ActivityService {

    public ResultInfo addActivity(int userId, Activity activity);//发布活动

}
