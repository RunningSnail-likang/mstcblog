package com.seu.mstc.service;

import com.seu.mstc.model.MyCollection;
import com.seu.mstc.result.ResultInfo;

/**
 * Created by lk on 2018/5/3.
 */
public interface CollectionService {

    public ResultInfo addCollection(int userId, MyCollection myCollection);//添加收藏

}
