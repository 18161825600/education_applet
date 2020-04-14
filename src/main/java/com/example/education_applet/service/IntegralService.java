package com.example.education_applet.service;

import com.example.education_applet.request.*;
import com.example.education_applet.request.integralRequest.SelectIntegralByGetWayRequest;
import com.example.education_applet.request.integralRequest.SelectIntegralByUserIdAndGetWayRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.integralResponse.SelectAllIntegralResponse;
import com.example.education_applet.response.integralResponse.SelectCheckInByUserIdResponse;
import com.example.education_applet.response.integralResponse.SelectIntegralByGetWayRsponse;
import com.example.education_applet.response.integralResponse.SelectIntegralByUserIdResponse;

import java.text.ParseException;

public interface IntegralService {

    Integer insertIntegral(UserIdRequest userIdRequest) throws ParseException;

    SelectIntegralByUserIdResponse selectIntegralByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectIntegralByGetWayRsponse selectIntegralByGetWay(SelectIntegralByGetWayRequest selectIntegralByGetWayRequest);

    SelectIntegralByUserIdResponse selectIntegralByUserIdAndGetWay(SelectIntegralByUserIdAndGetWayRequest selectIntegralByUserIdAndGetWayRequest);

    SelectCheckInByUserIdResponse selectCheckInByUserId(UserIdRequest userIdRequest) throws ParseException;

    SelectAllIntegralResponse selectAllIntegral(PageNumRequest pageNumRequest);
}
