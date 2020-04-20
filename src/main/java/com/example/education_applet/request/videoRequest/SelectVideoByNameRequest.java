package com.example.education_applet.request.videoRequest;

/**
 * 通过视频名称查找视频的请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectVideoByNameRequest implements Serializable {

    private static final long serialVersionUID = 8449716705969985112L;

    @ApiModelProperty(value = "视频名")
    private String videoName;

    private Integer pageNum=1;
}
