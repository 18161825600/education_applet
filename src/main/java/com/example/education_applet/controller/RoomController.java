package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.RoomIdAndUserIdRequest;
import com.example.education_applet.request.roomRequest.*;
import com.example.education_applet.response.roomResponse.RoomByIdResponse;
import com.example.education_applet.response.roomResponse.SelectRoomResponse;
import com.example.education_applet.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(value = "insert/room")
    public EducationJsonResult<String> insertRoom(@RequestBody AddRoomRequest addRoomRequest){
        Integer integer = roomService.insertRoom(addRoomRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "update/room/state")
    public EducationJsonResult<String> updateRoomState(@RequestBody UpdateRoomStateRequest updateRoomStateRequest){
        Integer integer = roomService.updateRoomState(updateRoomStateRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "update/room/name")
    public EducationJsonResult<String> updateRoomName(@RequestBody UpdateRoomNameRequest updateRoomNameRequest){
        Integer integer = roomService.updateRoomName(updateRoomNameRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "update/room/title")
    public EducationJsonResult<String> updateRoomTitle(@RequestBody UpdateRoomTitleRequest updateRoomTitleRequest){
        Integer integer = roomService.updateRoomTitle(updateRoomTitleRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "update/room/picture")
    public EducationJsonResult<String> updateRoomPicture(@RequestBody UpdateRoomPictureRequest updateRoomPictureRequest){
        Integer integer = roomService.updateRoomPicture(updateRoomPictureRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "select/room/by/id")
    public EducationJsonResult<RoomByIdResponse> selectRoomById(@RequestBody RoomIdAndUserIdRequest roomIdAndUserIdRequest){
        return EducationJsonResult.ok(roomService.selectRoomById(roomIdAndUserIdRequest));
    }

    @PostMapping(value = "select/room/by/name")
    public EducationJsonResult<SelectRoomResponse> selectRoomByName(@RequestBody RoomNameRequest roomNameRequest){
        return EducationJsonResult.ok(roomService.selectRoomByName(roomNameRequest));
    }

    @PostMapping(value = "select/room/by/state")
    public EducationJsonResult<SelectRoomResponse> selectRoomByState(@RequestBody RoomStateRequest roomStateRequest){
        return EducationJsonResult.ok(roomService.selectRoomByState(roomStateRequest));
    }

    @PostMapping(value = "select/all/room")
    public EducationJsonResult<SelectRoomResponse> selectAllRoom(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(roomService.selectAllRoom(pageNumRequest));
    }
}
