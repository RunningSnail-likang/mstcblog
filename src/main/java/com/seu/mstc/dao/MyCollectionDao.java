package com.seu.mstc.dao;

import com.seu.mstc.model.MyCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface MyCollectionDao {
    String TABLE_NAME=" my_collection ";
    String INSERT_FIELDS="  user_id, entity_id, entity_type, create_time  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId},#{entityId},#{entityType},#{createTime})"})
    int addMyCollection(MyCollection myCollection);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    MyCollection selectMyCollectionById(int id);



}
