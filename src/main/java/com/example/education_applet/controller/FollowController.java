package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.followRequest.AddFollowRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.followResponse.AllFollowResponse;
import com.example.education_applet.response.followResponse.SelectFollowByRoomIdResponse;
import com.example.education_applet.response.followResponse.SelectFollowByUserIdResponse;
import com.example.education_applet.service.FollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户关注直播间")
@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @ApiOperation(value = "通过用户id和直播间id添加关注记录")
    @PostMapping(value = "insert/follow")
    public EducationJsonResult<String> insertFollow(@RequestBody AddFollowRequest addFollowRequest){
        Integer integer = followService.insertFollow(addFollowRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过关注的主键id批量删除关注记录")
    @PostMapping(value = "delete/follow")
    public EducationJsonResult<Integer> deleteFollow(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(followService.deleteFollow(idsRequest));
    }

    @ApiOperation(value = "通过用户id查看该用户的关注记录")
    @PostMapping(value = "select/follow/by/userId")
    public EducationJsonResult<SelectFollowByUserIdResponse> selectFollowByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(followService.selectFollowByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过房间id查看该直播间被哪些用户关注")
    @PostMapping(value = "select/follow/by/roomId")
    public EducationJsonResult<SelectFollowByRoomIdResponse> selectFollowByRoomId(@RequestBody RoomIdAndPageNumRequest roomIdAndPageNumRequest){
        return EducationJsonResult.ok(followService.selectFollowByRoomId(roomIdAndPageNumRequest));
    }

    @ApiOperation(value = "查看数据库中的全部关注记录")
    @PostMapping(value = "select/all/follow")
    public EducationJsonResult<AllFollowResponse> selectAllFollow(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(followService.selectAllFollow(pageNumRequest));
    }
}
