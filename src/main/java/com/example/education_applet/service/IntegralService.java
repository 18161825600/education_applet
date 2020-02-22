package com.example.education_applet.service;

import com.example.education_applet.pojo.Integral;
import com.example.education_applet.request.*;
import com.example.education_applet.response.SelectAllIntegralResponse;
import com.example.education_applet.response.SelectIntegralByGetWayRsponse;
import com.example.education_applet.response.SelectIntegralByUserIdResponse;

import java.util.List;

public interface IntegralService {

    Integer insertIntegral(UserIdRequest userIdRequest);

    SelectIntegralByUserIdResponse selectIntegralByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectIntegralByGetWayRsponse selectIntegralByGetWay(SelectIntegralByGetWayRequest selectIntegralByGetWayRequest);

    SelectIntegralByUserIdResponse selectIntegralByUserIdAndGetWay(SelectIntegralByUserIdAndGetWayRequest selectIntegralByUserIdAndGetWayRequest);

    SelectAllIntegralResponse selectAllIntegral(PageNumRequest pageNumRequest);
}
