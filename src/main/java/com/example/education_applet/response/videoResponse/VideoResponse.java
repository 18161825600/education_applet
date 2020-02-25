package com.example.education_applet.response.videoResponse;

/**
 * 视频的返回值
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class VideoResponse implements Serializable {

    private static final long serialVersionUID = 4530728887134352858L;
    private Long id;

    private String videoName;

    private String videoPicture;

    private String videoContent;

    private Short isVipVideo;
}
