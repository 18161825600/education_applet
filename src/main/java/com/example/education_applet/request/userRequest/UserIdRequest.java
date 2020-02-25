package com.example.education_applet.request.userRequest;

/**
 * 用户id请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UserIdRequest implements Serializable {

    private static final long serialVersionUID = 7636468110788773126L;

    private Long userId;
}
