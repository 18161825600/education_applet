package com.example.education_applet.response;

/**
 * 获得积分路径的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class IntegralByGetWayResponse {

    private String nickName;

    private Integer getIntegralNum;

    private Date createTime;
}
