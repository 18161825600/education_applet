package com.example.education_applet.dao;

import com.example.education_applet.mapper.ChatRecordMapper;
import com.example.education_applet.pojo.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Repository
public class ChatRecordDao {

    @Autowired
    private ChatRecordMapper chatRecordMapper;

    public Integer insertChatRecord(ChatRecord chatRecord){
        return chatRecordMapper.insert(chatRecord);
    }

    public ChatRecord selectChatRecordById(Long id){
        return chatRecordMapper.selectByPrimaryKey(id);
    }

    public List<ChatRecord> selectChatRecordByUserId(Long userId){
        Example example = new Example(ChatRecord.class);
        example.createCriteria().andEqualTo("userId",userId);
        return chatRecordMapper.selectByExample(example);
    }

    public List<ChatRecord> selectChaetRecordByRoomId(Long roomId){
        Example example = new Example(ChatRecord.class);
        example.createCriteria().andEqualTo("roomId",roomId);
        return chatRecordMapper.selectByExample(example);
    }

    public List<ChatRecord> selectChatRecordByRoomIdAndTime(Long roomId, Date time){
        Example example = new Example(ChatRecord.class);
        example.orderBy("sendTime").asc();
        example.createCriteria().andEqualTo("roomId",roomId)
                .andGreaterThanOrEqualTo("sendTime",time);
        return chatRecordMapper.selectByExample(example);
    }

    public List<ChatRecord> selectAllChatRecord(){
        return chatRecordMapper.selectAll();
    }

    public Integer countChatRecordByUserId(Long userId) {
        Example example = new Example(ChatRecord.class);
        example.createCriteria().andEqualTo("userId", userId);
        return chatRecordMapper.selectCountByExample(example);
    }

    public Integer countChaetRecordByRoomId(Long roomId) {
        Example example = new Example(ChatRecord.class);
        example.createCriteria().andEqualTo("roomId", roomId);
        return chatRecordMapper.selectCountByExample(example);
    }

    public Integer countChatRecordByRoomIdAndSendTime(Long roomId, Date time) {
        Example example = new Example(ChatRecord.class);
        example.createCriteria().andEqualTo("roomId", roomId)
                .andGreaterThanOrEqualTo("sendTime", time);
        return chatRecordMapper.selectCountByExample(example);
    }

    public Integer countAllChatRecord(){
        Example example = new Example(ChatRecord.class);
        return chatRecordMapper.selectCountByExample(example);
    }
}
