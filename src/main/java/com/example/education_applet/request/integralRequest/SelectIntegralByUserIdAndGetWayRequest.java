package com.example.education_applet.request.integralRequest;

/**
 * 按用户id和获得途径查找获得积分记录的请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectIntegralByUserIdAndGetWayRequest implements Serializable {

    private static final long serialVersionUID = -4899395021503484971L;
    private Long userId;

    private String getIntegralWay;

    private Integer pageNum;
}
