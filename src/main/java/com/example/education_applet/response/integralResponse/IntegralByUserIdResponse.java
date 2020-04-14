package com.example.education_applet.response.integralResponse;

/**
 * 用户id获得积分记录的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IntegralByUserIdResponse implements Serializable {

    private static final long serialVersionUID = -6941826477613786112L;
    private Integer getIntegralNum;

    private String getIntegralWay;

    private String createTime;
}
