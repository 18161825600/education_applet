package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.pojo.ChatRecord;
import com.example.education_applet.request.ChatRecordRequest.AddChatRecordRequest;
import com.example.education_applet.request.ChatRecordRequest.SelectChatRecordByRoomIdAndTimeRequest;
import com.example.education_applet.response.ChatRecordResponse.SelectChatRecordByRoomIdAndTimeResponse;
import com.example.education_applet.service.ChatRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "直播间内发送消息记录")
@RestController
public class ChatRecordController {

    @Autowired
    private ChatRecordService chatRecordService;

    @ApiOperation(value = "用户发送弹幕(User)")
    @PostMapping(value = "insert/chatRecord")
    public EducationJsonResult<String> insertChatRecord(@RequestBody AddChatRecordRequest addChatRecordRequest){
        Integer integer = chatRecordService.insertChatRecord(addChatRecordRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过房间id和用户id和当前时间查找消息记录(*)")
    @PostMapping(value = "select/chatRecord")
    public EducationJsonResult<SelectChatRecordByRoomIdAndTimeResponse> selectSelectChatRecordByRoomIdAndTime(@RequestBody SelectChatRecordByRoomIdAndTimeRequest selectChatRecordByRoomIdAndTimeRequest){
        return EducationJsonResult.ok(chatRecordService.selectSelectChatRecordByRoomIdAndTime(selectChatRecordByRoomIdAndTimeRequest));
    }
}
