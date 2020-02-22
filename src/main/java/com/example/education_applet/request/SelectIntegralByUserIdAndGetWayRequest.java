package com.example.education_applet.request;

/**
 * 按用户id和获得途径查找获得积分记录的请求
 */

import lombok.Data;

@Data
public class SelectIntegralByUserIdAndGetWayRequest {

    private Long userId;

    private String getIntegralWay;

    private Integer pageNum;
}
