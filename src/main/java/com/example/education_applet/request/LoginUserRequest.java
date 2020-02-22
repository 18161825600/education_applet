package com.example.education_applet.request;

/**
 * 用户登录请求
 */

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class LoginUserRequest {

    private HttpServletRequest request;

    private String code;

}
