package com.example.education_applet.service;

import com.example.education_applet.pojo.User;
import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.OpenIdRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.userResponse.FindUserByOpenIdResponse;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;

public interface UserService {

    Integer insertUser(User user);

    Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest);

    FindUserByOpenIdResponse findUserByOpenId(OpenIdRequest openIdRequest);

    User userByOpenId(String openId);

    SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest);
}
