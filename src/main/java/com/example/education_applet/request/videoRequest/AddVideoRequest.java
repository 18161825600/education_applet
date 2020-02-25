package com.example.education_applet.request.videoRequest;

/**
 * 添加视频请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class AddVideoRequest implements Serializable {

    private static final long serialVersionUID = 4871670283647955124L;
    private String videoName;

    private Double videoSize;

    private String videoPicture;

    private String videoUrl;

    private String videoType;

    private String videoContent;

    private Short isVipVideo;
}
