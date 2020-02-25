package com.example.education_applet.response.userResponse;

/**
 * 用户登录的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUserResponse implements Serializable {

    private static final long serialVersionUID = 7880583397593331665L;
    private Long id;

    private String session_key;

    private String nickName;

    private String headUrl;

    private Integer integral;

    private Short isVip;

    private Date vipDueTime;
}
