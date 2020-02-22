package com.example.education_applet.response;

/**
 * 按获得积分途径的积分记录的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectIntegralByGetWayRsponse {

    private List<IntegralByGetWayResponse> integralByGetWayResponseList;

    private Integer total;
}
