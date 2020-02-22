package com.example.education_applet.request;

/**
 * 通过视频名称查找视频的请求
 */

import lombok.Data;

@Data
public class SelectVideoByNameRequest {

    private String videoName;

    private Integer pageNum;
}
