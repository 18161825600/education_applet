package com.example.education_applet.service;

import com.example.education_applet.pojo.User;
import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;

public interface UserService {

    Integer insertUser(User user);

    Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest);

    User findUserByOpenId(String openId);

    SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest);
}
