package com.example.education_applet.response;

/**
 * 查找视频的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectVideoResponse {

    private List<VideoResponse> videoResponseList;

    private Integer total;
}
