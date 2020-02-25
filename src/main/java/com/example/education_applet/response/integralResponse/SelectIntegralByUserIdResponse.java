package com.example.education_applet.response.integralResponse;

/**
 * 按用户id查找积分记录的返回值
 */

import com.example.education_applet.response.integralResponse.IntegralByUserIdResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectIntegralByUserIdResponse implements Serializable {

    private static final long serialVersionUID = 1386454783591758263L;
    private List<IntegralByUserIdResponse> integralByUserIdResponseList;

    private Integer total;
}
