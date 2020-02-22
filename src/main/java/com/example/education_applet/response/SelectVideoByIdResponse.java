package com.example.education_applet.response;

/**
 * 通过视频id查找视频的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class SelectVideoByIdResponse {

    private String videoName;

    private Double videoSize;

    private String videoPicture;

    private String videoUrl;

    private String videoType;

    private String videoContent;

    private Short isVipVideo;

    private Date createTime;
}
