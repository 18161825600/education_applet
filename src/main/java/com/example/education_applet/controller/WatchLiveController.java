package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.watchLiveResponse.AllWatchLiveResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByRoomIdResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByUserIdResponse;
import com.example.education_applet.service.WatchLiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "观看直播历史记录")
@RestController
public class WatchLiveController {

    @Autowired
    private WatchLiveService watchLiveService;

    @ApiOperation(value = "用户删除看直播的记录")
    @PostMapping(value = "delete/watchLive")
    public EducationJsonResult<Integer> deleteWatchLiva(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(watchLiveService.deleteWatchLiva(idsRequest));
    }

    @ApiOperation(value = "通过用户id查找该用户观看直播的历史记录")
    @PostMapping(value = "select/watchLive/by/userId")
    public EducationJsonResult<SelectWatchLiveByUserIdResponse> selectWatchLiveByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectWatchLiveByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过房间id查看该直播间有哪些用户观看过")
    @PostMapping(value = "select/watchLive/by/roomId")
    public EducationJsonResult<SelectWatchLiveByRoomIdResponse> selectWatchLiveByRoomId(@RequestBody RoomIdAndPageNumRequest roomIdAndPageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectWatchLiveByRoomId(roomIdAndPageNumRequest));
    }

    @ApiOperation(value = "查找数据库中所有的观看记录")
    @PostMapping(value = "select/all/watchLive")
    public EducationJsonResult<AllWatchLiveResponse> selectAllWatchLive(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(watchLiveService.selectAllWatchLive(pageNumRequest));
    }
}
