package com.seu.mstc.dao;

import com.seu.mstc.model.BlogComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface BlogCommentDao {
    String TABLE_NAME=" blog_comment ";
    String INSERT_FIELDS="  entity_id, entity_type, user_id, to_user_id, create_time, content, status, image_url, like_count, dislike_count  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{entityId},#{entityType},#{userId},#{toUserId},#{createTime},#{content}," +
                    "#{status},#{imageUrl},#{likeCount},#{dislikeCount})"})
    int addBlogComment(BlogComment blogComment);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    BlogComment selectBlogCommentById(int id);

    @Update({"update ",TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateStatus(BlogComment blogComment);


}
