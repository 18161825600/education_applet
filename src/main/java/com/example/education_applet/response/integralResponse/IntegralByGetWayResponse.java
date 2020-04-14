package com.example.education_applet.response.integralResponse;

/**
 * 获得积分路径的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IntegralByGetWayResponse implements Serializable {

    private static final long serialVersionUID = 2177954170815076862L;
    private String nickName;

    private Integer getIntegralNum;

    private String createTime;
}
