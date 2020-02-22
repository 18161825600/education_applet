package com.example.education_applet.service;

import com.example.education_applet.request.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.LoginUserResponse;
import com.example.education_applet.response.SelectAllUserResponse;
import com.example.education_applet.response.SelectUserResponse;

public interface UserService {

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest);

    SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest);
}
