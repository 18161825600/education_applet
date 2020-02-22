package com.example.education_applet.response;

/**
 * 用户登录的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class LoginUserResponse {

    private Long id;

    private String session_key;

    private String nickName;

    private String headUrl;

    private Integer integral;

    private Short isVip;

    private Date vipDueTime;
}
