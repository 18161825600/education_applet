package com.example.education_applet.request.videoRequest;

/**
 * 通过视频类型查找视频请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectVideoByTypeRequest implements Serializable {

    private static final long serialVersionUID = -4651354600040283159L;

    @ApiModelProperty(value = "视频类型")
    private String videoType;

    private Integer pageNum=1;
}
