package com.example.education_applet.request.integralRequest;

/**
 * 按用户id和获得途径查找获得积分记录的请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectIntegralByUserIdAndGetWayRequest implements Serializable {

    private static final long serialVersionUID = -4899395021503484971L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "获得积分的途径")
    private String getIntegralWay;

    private Integer pageNum = 1;
}
