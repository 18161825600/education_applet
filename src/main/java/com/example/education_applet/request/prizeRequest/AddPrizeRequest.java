package com.example.education_applet.request.prizeRequest;

/**
 * 添加奖品请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddPrizeRequest implements Serializable {

    private static final long serialVersionUID = 5944099664944952200L;

    @ApiModelProperty(value = "奖品名字")
    private String prizeName;

    @ApiModelProperty(value = "奖品描述")
    private String prizeContent;

    @ApiModelProperty(value = "所需积分")
    private Integer prizeIntegral;

    @ApiModelProperty(value = "奖品数量")
    private Integer prizeNum;
}
