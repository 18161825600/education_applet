package com.example.education_applet.response;

/**
 * 查找用户的返回值
 */

import lombok.Data;

import java.util.Date;

@Data
public class SelectUserResponse {

    private Long id;

    private String openId;

    private String nickName;

    private String phoneNum;

    private String headUrl;

    private Integer integral;

    private Short isVip;

    private Date vipDueTime;

    private Short userPower;

    private Date createTime;
}
