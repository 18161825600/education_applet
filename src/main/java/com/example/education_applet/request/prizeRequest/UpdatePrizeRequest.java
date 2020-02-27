package com.example.education_applet.request.prizeRequest;

/**
 * 修改奖品的请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePrizeRequest implements Serializable {

    private static final long serialVersionUID = 1917983902103786498L;

    @ApiModelProperty(value = "奖品的主键id")
    private Long id;

    @ApiModelProperty(value = "奖品名")
    private String prizeName;

    @ApiModelProperty(value = "奖品描述")
    private String prizeContent;

    @ApiModelProperty(value = "所需积分")
    private Integer prizeIntegral;

    @ApiModelProperty(value = "奖品数量")
    private Integer prizeNum;
}
