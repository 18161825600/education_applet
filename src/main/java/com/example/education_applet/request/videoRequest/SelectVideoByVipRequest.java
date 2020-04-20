package com.example.education_applet.request.videoRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 查找vip视频的请求
 */

@Data
public class SelectVideoByVipRequest implements Serializable {

    private static final long serialVersionUID = -5291192119362908133L;

    @ApiModelProperty(value = "是否VIP视频")
    private String isVipVideo;

    private Integer pageNum=1;
}
