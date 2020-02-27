package com.example.education_applet.request.videoRequest;

/**
 * 修改视频是否是vip视频的请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateVideoVipRequest implements Serializable {

    private static final long serialVersionUID = -4365911327344702365L;

    @ApiModelProperty(value = "视频id")
    private Long id;

    @ApiModelProperty(value = "0是普通1是VIP")
    private Short isVipVideo;
}
