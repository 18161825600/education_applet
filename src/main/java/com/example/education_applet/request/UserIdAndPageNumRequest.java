package com.example.education_applet.request;

/**
 * 用户id和页数请求
 */

import lombok.Data;

@Data
public class UserIdAndPageNumRequest {

    private Long userId;

    private Integer pageNum;
}
