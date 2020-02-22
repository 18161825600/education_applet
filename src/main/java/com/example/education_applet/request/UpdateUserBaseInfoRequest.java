package com.example.education_applet.request;

/**
 * 修改用户基础信息的请求
 */

import lombok.Data;

@Data
public class UpdateUserBaseInfoRequest {

    private Long id;

    private String nickName;

    private String phoneNum;

    private String headUrl;
}
