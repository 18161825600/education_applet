package com.example.education_applet.service;

import com.example.education_applet.request.IdAndUserIdRequest;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.RoomIdAndUserIdRequest;
import com.example.education_applet.request.roomRequest.*;
import com.example.education_applet.response.roomResponse.RoomByIdResponse;
import com.example.education_applet.response.roomResponse.SelectRoomResponse;

public interface RoomService {

    Integer insertRoom(AddRoomRequest addRoomRequest);

    Integer updateRoomState(UpdateRoomStateRequest updateRoomStateRequest);

    Integer updateRoomName(UpdateRoomNameRequest updateRoomNameRequest);

    Integer updateRoomTitle(UpdateRoomTitleRequest updateRoomTitleRequest);

    Integer updateRoomPicture(UpdateRoomPictureRequest updateRoomPictureRequest);

    RoomByIdResponse selectRoomById(RoomIdAndUserIdRequest roomIdAndUserIdRequest);

    SelectRoomResponse selectRoomByName(RoomNameRequest roomNameRequest);

    SelectRoomResponse selectRoomByState(RoomStateRequest roomStateRequest);

    SelectRoomResponse selectAllRoom(PageNumRequest pageNumRequest);
}
