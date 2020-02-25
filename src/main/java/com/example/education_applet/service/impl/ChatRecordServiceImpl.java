package com.example.education_applet.service.impl;

import com.example.education_applet.dao.ChatRecordDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.WatchLiveDao;
import com.example.education_applet.pojo.ChatRecord;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.WatchLive;
import com.example.education_applet.request.ChatRecordRequest.AddChatRecordRequest;
import com.example.education_applet.request.ChatRecordRequest.SelectChatRecordByRoomIdAndTimeRequest;
import com.example.education_applet.response.ChatRecordResponse.ChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.response.ChatRecordResponse.SelectChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.service.ChatRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatRecordServiceImpl implements ChatRecordService {

    @Autowired
    private ChatRecordDao chatRecordDao;
    @Autowired
    private WatchLiveDao watchLiveDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer insertChatRecord(AddChatRecordRequest addChatRecordRequest) {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setUserId(addChatRecordRequest.getUserId());
        chatRecord.setRoomId(addChatRecordRequest.getRoomId());
        chatRecord.setUserMessage(addChatRecordRequest.getUserMessage());
        chatRecord.setSendTime(new Date());
        return chatRecordDao.insertChatRecord(chatRecord);
    }

    @Override
    public SelectChatRecordByRoomIdAndTimeResponse selectSelectChatRecordByRoomIdAndTime(SelectChatRecordByRoomIdAndTimeRequest selectChatRecordByRoomIdAndTimeRequest) {
        WatchLive watchLive = watchLiveDao.selectWatchLiveByUserIdAndRoomId(selectChatRecordByRoomIdAndTimeRequest.getUserId(), selectChatRecordByRoomIdAndTimeRequest.getRoomId());
        List<ChatRecord> chatRecords = chatRecordDao.selectChatRecordByRoomIdAndTime(selectChatRecordByRoomIdAndTimeRequest.getRoomId(),watchLive.getReceiveTime());

        watchLive.setReceiveTime(new Date());
        watchLiveDao.updateWatchLive(watchLive);

        SelectChatRecordByRoomIdAndTimeResponse response = new SelectChatRecordByRoomIdAndTimeResponse();
        List<ChatRecordByRoomIdAndTimeResponse> list = new ArrayList<>();
        for (ChatRecord chatRecord : chatRecords) {
            ChatRecordByRoomIdAndTimeResponse record = new ChatRecordByRoomIdAndTimeResponse();

            User user = userDao.selectUserById(chatRecord.getUserId());
            BeanUtils.copyProperties(user,record);

            record.setUserMessage(chatRecord.getUserMessage());
            list.add(record);
        }
        response.setChatRecordList(list);
        return response;
    }
}
