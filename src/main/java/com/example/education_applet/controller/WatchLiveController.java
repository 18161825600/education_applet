package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.watchLiveResponse.AllWatchLiveResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByRoomIdResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByUserIdResponse;
import com.example.education_applet.service.WatchLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchLiveController {

    @Autowired
    private WatchLiveService watchLiveService;

    @PostMapping(value = "select/watchLive/by/userId")
    public EducationJsonResult<SelectWatchLiveByUserIdResponse> selectWatchLiveByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectWatchLiveByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/watchLive/by/roomId")
    public EducationJsonResult<SelectWatchLiveByRoomIdResponse> selectWatchLiveByRoomId(@RequestBody RoomIdAndPageNumRequest roomIdAndPageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectWatchLiveByRoomId(roomIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/watchLive")
    public EducationJsonResult<AllWatchLiveResponse> selectAllWatchLive(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectAllWatchLive(pageNumRequest));
    }
}
