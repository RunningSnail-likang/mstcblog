package com.seu.mstc.dao;

import com.seu.mstc.model.Blog;
import com.seu.mstc.model.Programming;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface ProgrammingDao {
    String TABLE_NAME=" programming ";
    String INSERT_FIELDS="  user_id, title, ideas, answer, image_url, create_time, status," +
            " flag, like_count, dislike_count, is_top  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId},#{title},#{ideas},#{answer},#{imageUrl},#{createTime}," +
                    "#{status},#{flag},#{likeCount},#{dislikeCount},#{isTop})"})
    int addProgramming(Programming programming);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Blog selectProgrammingById(int id);


    @Update({"update ",TABLE_NAME, " set is_top=#{isTop} where id=#{id}"})
    void updateIsTop(Programming programming);




}
