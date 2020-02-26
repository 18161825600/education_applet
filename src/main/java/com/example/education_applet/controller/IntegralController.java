package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.*;
import com.example.education_applet.request.integralRequest.SelectIntegralByGetWayRequest;
import com.example.education_applet.request.integralRequest.SelectIntegralByUserIdAndGetWayRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.integralResponse.SelectAllIntegralResponse;
import com.example.education_applet.response.integralResponse.SelectIntegralByGetWayRsponse;
import com.example.education_applet.response.integralResponse.SelectIntegralByUserIdResponse;
import com.example.education_applet.service.IntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "获得积分记录")
@RestController
public class IntegralController {

    @Autowired
    private IntegralService integralService;

    @ApiOperation(value = "通过用户id进行签到")
    @PostMapping(value = "check/in")
    public EducationJsonResult<String> checkIn(@RequestBody UserIdRequest userIdRequest){
        Integer integer = integralService.insertIntegral(userIdRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过用户id查看该用户的所有获得积分记录")
    @PostMapping(value = "select/integral/by/userId")
    public EducationJsonResult<SelectIntegralByUserIdResponse> selectIntegralByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(integralService.selectIntegralByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过获得积分的路径查看数据库中有哪些记录")
    @PostMapping(value = "select/integral/by/getWay")
    public EducationJsonResult<SelectIntegralByGetWayRsponse> selectIntegralByGetWay(@RequestBody SelectIntegralByGetWayRequest selectIntegralByGetWayRequest){
        return EducationJsonResult.ok(integralService.selectIntegralByGetWay(selectIntegralByGetWayRequest));
    }

    @ApiOperation(value = "通过用户id和获得途径查看该用户的记录")
    @PostMapping(value = "select/integral/userId/getWay")
    public EducationJsonResult<SelectIntegralByUserIdResponse> selectIntegralByUserIdAndGetWay(@RequestBody SelectIntegralByUserIdAndGetWayRequest selectIntegralByUserIdAndGetWayRequest){
        return EducationJsonResult.ok(integralService.selectIntegralByUserIdAndGetWay(selectIntegralByUserIdAndGetWayRequest));
    }

    @ApiOperation(value = "查看数据库中的所有获得积分记录")
    @PostMapping(value = "select/all/integral")
    public EducationJsonResult<SelectAllIntegralResponse> selectAllIntegral(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(integralService.selectAllIntegral(pageNumRequest));
    }
}
