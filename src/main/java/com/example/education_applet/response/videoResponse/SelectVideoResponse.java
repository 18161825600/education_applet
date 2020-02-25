package com.example.education_applet.response.videoResponse;

/**
 * 查找视频的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectVideoResponse implements Serializable {

    private static final long serialVersionUID = -1868071134382682834L;
    private List<VideoResponse> videoResponseList;

    private Integer total;
}
