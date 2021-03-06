package com.example.education_applet.service;

import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.watchLiveResponse.AllWatchLiveResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByRoomIdResponse;
import com.example.education_applet.response.watchLiveResponse.SelectWatchLiveByUserIdResponse;

import java.io.UnsupportedEncodingException;

public interface WatchLiveService {

    Integer deleteWatchLiva(IdsRequest idsRequest);

    SelectWatchLiveByUserIdResponse selectWatchLiveByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectWatchLiveByRoomIdResponse selectWatchLiveByRoomId(RoomIdAndPageNumRequest roomIdAndPageNumRequest) throws UnsupportedEncodingException;

    AllWatchLiveResponse selectAllWatchLive(PageNumRequest pageNumRequest) throws UnsupportedEncodingException;
}
