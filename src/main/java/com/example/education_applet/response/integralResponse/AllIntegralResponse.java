package com.example.education_applet.response.integralResponse;

/**
 * 积分记录的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AllIntegralResponse implements Serializable {

    private static final long serialVersionUID = -5187502725068676076L;
    private String nickName;

    private Integer getIntegralNum;

    private String getIntegralWay;

    private String createTime;
}
