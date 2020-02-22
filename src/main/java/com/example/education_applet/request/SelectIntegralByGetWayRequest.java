package com.example.education_applet.request;

/**
 * 按获得积分的途径查找记录请求
 */

import lombok.Data;

@Data
public class SelectIntegralByGetWayRequest {

    private String getWay;

    private Integer pageNum;
}
