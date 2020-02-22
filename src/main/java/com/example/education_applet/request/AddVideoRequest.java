package com.example.education_applet.request;

/**
 * 添加视频请求
 */

import lombok.Data;

@Data
public class AddVideoRequest {

    private String videoName;

    private Double videoSize;

    private String videoPicture;

    private String videoUrl;

    private String videoType;

    private String videoContent;

    private Short isVipVideo;
}
