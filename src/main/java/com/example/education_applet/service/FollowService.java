package com.example.education_applet.service;

import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.followRequest.AddFollowRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.followResponse.AllFollowResponse;
import com.example.education_applet.response.followResponse.FollowByIdResponse;
import com.example.education_applet.response.followResponse.SelectFollowByRoomIdResponse;
import com.example.education_applet.response.followResponse.SelectFollowByUserIdResponse;

import java.io.UnsupportedEncodingException;

public interface FollowService {

    Integer insertFollow(AddFollowRequest addFollowRequest);

    Integer deleteFollow(IdsRequest idsRequest);

    SelectFollowByUserIdResponse selectFollowByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) throws UnsupportedEncodingException;

    SelectFollowByRoomIdResponse selectFollowByRoomId(RoomIdAndPageNumRequest roomIdAndPageNumRequest) throws UnsupportedEncodingException;

    AllFollowResponse selectAllFollow(PageNumRequest pageNumRequest) throws UnsupportedEncodingException;
}
