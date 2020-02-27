package com.example.education_applet.request.videoRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class VideoIdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = 230955716642392398L;

    @ApiModelProperty(value = "视频id")
    private Long videoId;

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;

}
