package com.example.education_applet.response.userResponse;

import lombok.Data;

import java.util.Date;

@Data
public class FindUserByOpenIdResponse {

    private Long id;

    private String openId;

    private String nickName;

    private String phoneNum;

    private String headUrl;

    private Integer integral;

    private Short isVip;

    private String vipDueTime;
}
