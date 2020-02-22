package com.example.education_applet.response;

/**
 * 按用户id查找积分记录的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectIntegralByUserIdResponse {

    private List<IntegralByUserIdResponse> integralByUserIdResponseList;

    private Integer total;
}
