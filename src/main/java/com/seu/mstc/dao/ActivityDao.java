package com.seu.mstc.dao;

import com.seu.mstc.model.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface ActivityDao {
    String TABLE_NAME=" activity ";
    String INSERT_FIELDS="  user_id, title, location, time, create_time, status, is_top, sponsor," +
            " image_url, content, like_count, dislike_count  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId},#{title},#{location},#{time},#{createTime},#{status}," +
                    "#{isTop},#{sponsor},#{imageUrl},#{content},#{likeCount},#{dislikeCount})"})
    int addActivity(Activity activity);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Activity selectActivityById(int id);


    @Update({"update ",TABLE_NAME, " set is_top=#{isTop} where id=#{id}"})
    void updateIsTop(Activity activity);




}
