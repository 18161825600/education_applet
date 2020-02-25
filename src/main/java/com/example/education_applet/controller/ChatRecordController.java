package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.pojo.ChatRecord;
import com.example.education_applet.request.ChatRecordRequest.AddChatRecordRequest;
import com.example.education_applet.request.ChatRecordRequest.SelectChatRecordByRoomIdAndTimeRequest;
import com.example.education_applet.response.ChatRecordResponse.SelectChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRecordController {

    @Autowired
    private ChatRecordService chatRecordService;

    @PostMapping(value = "insert/chatRecord")
    public EducationJsonResult<String> insertChatRecord(AddChatRecordRequest addChatRecordRequest){
        Integer integer = chatRecordService.insertChatRecord(addChatRecordRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "select/chatRecord")
    public EducationJsonResult<SelectChatRecordByRoomIdAndTimeResponse> selectSelectChatRecordByRoomIdAndTime(SelectChatRecordByRoomIdAndTimeRequest selectChatRecordByRoomIdAndTimeRequest){
        return EducationJsonResult.ok(chatRecordService.selectSelectChatRecordByRoomIdAndTime(selectChatRecordByRoomIdAndTimeRequest));
    }
}
