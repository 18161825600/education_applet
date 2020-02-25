package com.example.education_applet.request.integralRequest;

/**
 * 按获得积分的途径查找记录请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectIntegralByGetWayRequest implements Serializable {

    private static final long serialVersionUID = 9070034240382162189L;
    private String getWay;

    private Integer pageNum;
}
