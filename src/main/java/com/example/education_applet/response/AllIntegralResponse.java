package com.example.education_applet.response;

/**
 * 积分记录的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class AllIntegralResponse {

    private String nickName;

    private Integer getIntegralNum;

    private String getIntegralWay;

    private Date createTime;
}
