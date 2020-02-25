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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping(value = "insert/follow")
    public EducationJsonResult<String> insertFollow(@RequestBody AddFollowRequest addFollowRequest){
        Integer integer = followService.insertFollow(addFollowRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "delete/follow")
    public EducationJsonResult<Integer> deleteFollow(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(followService.deleteFollow(idsRequest));
    }

    @PostMapping(value = "select/follow/by/userId")
    public EducationJsonResult<SelectFollowByUserIdResponse> selectFollowByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(followService.selectFollowByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/follow/by/roomId")
    public EducationJsonResult<SelectFollowByRoomIdResponse> selectFollowByRoomId(@RequestBody RoomIdAndPageNumRequest roomIdAndPageNumRequest){
        return EducationJsonResult.ok(followService.selectFollowByRoomId(roomIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/follow")
    public EducationJsonResult<AllFollowResponse> selectAllFollow(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(followService.selectAllFollow(pageNumRequest));
    }
}
