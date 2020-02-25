package com.example.education_applet.request.videoRequest;

/**
 * 通过视频类型查找视频请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectVideoByTypeRequest implements Serializable {

    private static final long serialVersionUID = -4651354600040283159L;
    private String videoType;

    private Integer pageNum;
}
