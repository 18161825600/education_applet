package com.example.education_applet.request.getPrizeRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 添加兑换奖品的记录请求
 */

@Data
public class AddGetPrizeRequest implements Serializable {

    private static final long serialVersionUID = 2260003754361252121L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "奖品id")
    private Long prizeId;

}
