package com.example.education_applet.request.videoRequest;

/**
 * 添加视频请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddVideoRequest implements Serializable {

    private static final long serialVersionUID = 4871670283647955124L;

    @ApiModelProperty(value = "视频名")
    private String videoName;

    @ApiModelProperty(value = "视频大小")
    private Double videoSize;

    @ApiModelProperty(value = "封面图片")
    private String videoPicture;

    @ApiModelProperty(value = "视频地址")
    private String videoUrl;

    @ApiModelProperty(value = "视频类型")
    private String videoType;

    @ApiModelProperty(value = "视频内容")
    private String videoContent;

    @ApiModelProperty(value = "0是普通视频1是vip视频")
    private Short isVipVideo;
}
