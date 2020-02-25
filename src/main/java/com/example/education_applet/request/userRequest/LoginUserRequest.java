package com.example.education_applet.request.userRequest;

/**
 * 用户登录请求
 */

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
public class LoginUserRequest implements Serializable {

    private static final long serialVersionUID = 8395452222332036201L;
    private HttpServletRequest request;

    private String code;

}
