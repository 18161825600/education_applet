package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;
import com.example.education_applet.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录(Z&U)")
    @PostMapping(value = "login/user")
    public EducationJsonResult<LoginUserResponse> loginUser(@RequestBody LoginUserRequest loginUserRequest){
        return EducationJsonResult.ok(userService.loginUser(loginUserRequest));
    }

    @ApiOperation(value = "通过用户id修改用户信息(Z&U)")
    @PostMapping(value = "update/user/base/info")
    public EducationJsonResult<String> updateUserBaseInfo(@RequestBody UpdateUserBaseInfoRequest updateUserBaseInfoRequest){
        Integer integer = userService.updateUserBaseInfo(updateUserBaseInfoRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "查找数据库中所有的用户(Admin)")
    @PostMapping(value = "select/all/user")
    public EducationJsonResult<SelectAllUserResponse> selectAllUser(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(userService.selectAllUser(pageNumRequest));
    }
}
