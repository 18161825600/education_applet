package com.example.education_applet.service;

import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;

public interface UserService {

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest);

    SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest);
}
