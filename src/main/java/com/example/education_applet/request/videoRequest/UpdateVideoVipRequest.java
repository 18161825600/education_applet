package com.example.education_applet.request.videoRequest;

/**
 * 修改视频是否是vip视频的请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateVideoVipRequest implements Serializable {

    private static final long serialVersionUID = -4365911327344702365L;
    private Long id;

    private Short isVipVideo;
}
