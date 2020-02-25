package com.example.education_applet.response.integralResponse;

/**
 * 按获得积分途径的积分记录的返回值
 */

import com.example.education_applet.response.integralResponse.IntegralByGetWayResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectIntegralByGetWayRsponse implements Serializable {

    private static final long serialVersionUID = -6655804844418079643L;
    private List<IntegralByGetWayResponse> integralByGetWayResponseList;

    private Integer total;
}
