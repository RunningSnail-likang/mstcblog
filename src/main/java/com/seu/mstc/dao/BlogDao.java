package com.seu.mstc.dao;

import com.seu.mstc.model.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface BlogDao {
    String TABLE_NAME=" blog ";
    String INSERT_FIELDS="  user_id, title, blog_abstract, content, image_url, create_time, key_word, status," +
            " flag, like_count, dislike_count, is_top  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId},#{title},#{blogAbstract},#{content},#{imageUrl},#{createTime}," +
                    "#{keyWord},#{status},#{flag},#{likeCount},#{dislikeCount},#{isTop})"})
    int addBlog(Blog blog);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Blog selectBlogById(int id);


    @Update({"update ",TABLE_NAME, " set is_top=#{isTop} where id=#{id}"})
    void updateIsTop(Blog blog);




}
