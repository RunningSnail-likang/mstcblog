package com.seu.mstc.service;

import com.seu.mstc.model.Blog;
import com.seu.mstc.result.ResultInfo;

/**
 * Created by lk on 2018/5/3.
 */
public interface BlogService {

    public ResultInfo addBlog(int userId, Blog blog);//发布博文

}
