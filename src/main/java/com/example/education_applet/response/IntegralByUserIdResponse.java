package com.example.education_applet.response;

/**
 * 用户id获得积分记录的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class IntegralByUserIdResponse {

    private Integer getIntegralNum;

    private String getIntegralWay;

    private Date createTime;
}
