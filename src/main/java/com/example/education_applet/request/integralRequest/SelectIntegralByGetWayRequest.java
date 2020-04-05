package com.example.education_applet.request.integralRequest;

/**
 * 按获得积分的途径查找记录请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectIntegralByGetWayRequest implements Serializable {

    private static final long serialVersionUID = 9070034240382162189L;

    @ApiModelProperty(value = "获得积分的途径")
    private String getWay;

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;
}
