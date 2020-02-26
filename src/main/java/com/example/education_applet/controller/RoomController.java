package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.RoomIdAndUserIdRequest;
import com.example.education_applet.request.roomRequest.*;
import com.example.education_applet.response.roomResponse.RoomByIdResponse;
import com.example.education_applet.response.roomResponse.SelectRoomResponse;
import com.example.education_applet.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "直播间")
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ApiOperation(value = "新增直播间(Admin)")
    @PostMapping(value = "insert/room")
    public EducationJsonResult<String> insertRoom(@RequestBody AddRoomRequest addRoomRequest){
        Integer integer = roomService.insertRoom(addRoomRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过直播间的主键id修改直播间状态(ZhuBo)")
    @PostMapping(value = "update/room/state")
    public EducationJsonResult<String> updateRoomState(@RequestBody UpdateRoomStateRequest updateRoomStateRequest){
        Integer integer = roomService.updateRoomState(updateRoomStateRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过直播间的id修改直播间名字(ZhuBo)")
    @PostMapping(value = "update/room/name")
    public EducationJsonResult<String> updateRoomName(@RequestBody UpdateRoomNameRequest updateRoomNameRequest){
        Integer integer = roomService.updateRoomName(updateRoomNameRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过直播间的id修改直播间标题(ZhuBo)")
    @PostMapping(value = "update/room/title")
    public EducationJsonResult<String> updateRoomTitle(@RequestBody UpdateRoomTitleRequest updateRoomTitleRequest){
        Integer integer = roomService.updateRoomTitle(updateRoomTitleRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过直播间的id修改直播间封面图片(ZhuBo)")
    @PostMapping(value = "update/room/picture")
    public EducationJsonResult<String> updateRoomPicture(@RequestBody UpdateRoomPictureRequest updateRoomPictureRequest){
        Integer integer = roomService.updateRoomPicture(updateRoomPictureRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过直播间id查看直播间详情")
    @PostMapping(value = "select/room/by/id")
    public EducationJsonResult<RoomByIdResponse> selectRoomById(@RequestBody RoomIdAndUserIdRequest roomIdAndUserIdRequest){
        return EducationJsonResult.ok(roomService.selectRoomById(roomIdAndUserIdRequest));
    }

    @ApiOperation(value = "通过直播间的名字查找直播间")
    @PostMapping(value = "select/room/by/name")
    public EducationJsonResult<SelectRoomResponse> selectRoomByName(@RequestBody RoomNameRequest roomNameRequest){
        return EducationJsonResult.ok(roomService.selectRoomByName(roomNameRequest));
    }

    @ApiOperation(value = "通过直播间的状态(是不是开播)查找直播间")
    @PostMapping(value = "select/room/by/state")
    public EducationJsonResult<SelectRoomResponse> selectRoomByState(@RequestBody RoomStateRequest roomStateRequest){
        return EducationJsonResult.ok(roomService.selectRoomByState(roomStateRequest));
    }

    @ApiOperation(value = "查找所有直播间")
    @PostMapping(value = "select/all/room")
    public EducationJsonResult<SelectRoomResponse> selectAllRoom(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(roomService.selectAllRoom(pageNumRequest));
    }
}
