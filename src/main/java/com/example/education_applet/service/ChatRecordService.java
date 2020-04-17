package com.example.education_applet.service;

import com.example.education_applet.request.ChatRecordRequest.AddChatRecordRequest;
import com.example.education_applet.request.ChatRecordRequest.SelectChatRecordRequest;
import com.example.education_applet.response.ChatRecordResponse.SelectChatRecordByRoomIdAndTimeResponse;

import java.io.UnsupportedEncodingException;

public interface ChatRecordService {

    Integer insertChatRecord(AddChatRecordRequest addChatRecordRequest);

    SelectChatRecordByRoomIdAndTimeResponse selectSelectChatRecordByRoomIdAndTime(SelectChatRecordRequest selectChatRecordRequest) throws UnsupportedEncodingException;
}
