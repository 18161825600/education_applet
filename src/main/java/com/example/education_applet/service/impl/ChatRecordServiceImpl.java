package com.example.education_applet.service.impl;

import com.example.education_applet.dao.ChatRecordDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.WatchLiveDao;
import com.example.education_applet.pojo.ChatRecord;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.WatchLive;
import com.example.education_applet.request.ChatRecordRequest.AddChatRecordRequest;
import com.example.education_applet.request.ChatRecordRequest.SelectChatRecordRequest;
import com.example.education_applet.response.ChatRecordResponse.ChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.response.ChatRecordResponse.SelectChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.service.ChatRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public SelectChatRecordByRoomIdAndTimeResponse selectSelectChatRecordByRoomIdAndTime(SelectChatRecordRequest selectChatRecordByRoomIdAndTimeRequest) {
        //通过用户id和房间id拿到该用户的观看记录
        WatchLive watchLive = watchLiveDao.selectWatchLiveByUserIdAndRoomId(selectChatRecordByRoomIdAndTimeRequest.getUserId(), selectChatRecordByRoomIdAndTimeRequest.getRoomId());
        //通过房间id和用户最后拿到直播间弹幕的时间，查找的弹幕集合
        List<ChatRecord> chatRecords = chatRecordDao.selectChatRecordByRoomIdAndTime(selectChatRecordByRoomIdAndTimeRequest.getRoomId(),watchLive.getReceiveTime());

        //修改用户拿到直播间弹幕的时间
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
