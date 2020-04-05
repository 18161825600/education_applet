package com.example.education_applet.request.userRequest;

/**
 * 用户id请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserIdRequest implements Serializable {

    private static final long serialVersionUID = 7636468110788773126L;

    @ApiModelProperty(value = "用户id")
    private Long userId;
}
