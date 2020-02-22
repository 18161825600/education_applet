package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.LoginUserResponse;
import com.example.education_applet.response.SelectAllUserResponse;
import com.example.education_applet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "login/user")
    public EducationJsonResult<LoginUserResponse> loginUser(@RequestBody LoginUserRequest loginUserRequest){
        return EducationJsonResult.ok(userService.loginUser(loginUserRequest));
    }

    @PutMapping(value = "update/user/base/info")
    public EducationJsonResult<String> updateUserBaseInfo(@RequestBody UpdateUserBaseInfoRequest updateUserBaseInfoRequest){
        Integer integer = userService.updateUserBaseInfo(updateUserBaseInfoRequest);
        if(integer==1){
            return EducationJsonResult.ok("true");
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "select/all/user")
    public EducationJsonResult<SelectAllUserResponse> selectAllUser(PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(userService.selectAllUser(pageNumRequest));
    }
}
