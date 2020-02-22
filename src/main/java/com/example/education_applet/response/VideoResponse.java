package com.example.education_applet.response;

/**
 * 视频的返回值
 */

import lombok.Data;

@Data
public class VideoResponse {

    private Long id;

    private String videoName;

    private String videoPicture;

    private String videoContent;

    private Short isVipVideo;
}
