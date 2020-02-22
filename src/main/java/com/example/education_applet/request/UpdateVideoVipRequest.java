package com.example.education_applet.request;

/**
 * 修改视频是否是vip视频的请求
 */

import lombok.Data;

@Data
public class UpdateVideoVipRequest {

    private Long id;

    private Short isVipVideo;
}
