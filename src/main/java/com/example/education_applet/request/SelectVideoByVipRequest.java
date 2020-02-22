package com.example.education_applet.request;

import lombok.Data;

/**
 * 查找vip视频的请求
 */

@Data
public class SelectVideoByVipRequest {

    private String isVipVideo;

    private Integer pageNum;
}
