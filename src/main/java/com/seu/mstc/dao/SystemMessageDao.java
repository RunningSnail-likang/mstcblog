package com.seu.mstc.dao;

import com.seu.mstc.model.SystemMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface SystemMessageDao {
    String TABLE_NAME=" system_message ";
    String INSERT_FIELDS="  from_id, to_id, content, has_read, create_time  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{fromId},#{toId},#{content},#{hasRead},#{createTime})"})
    int addSystemMessage(SystemMessage systemMessage);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    SystemMessage selectSystemMessageById(int id);



}
