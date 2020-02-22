package com.example.education_applet.request;

/**
 * 通过视频类型查找视频请求
 */

import lombok.Data;

@Data
public class SelectVideoByTypeRequest {

    private String videoType;

    private Integer pageNum;
}
