package com.example.education_applet.request.userRequest;

/**
 * 用户id和页数请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserIdAndPageNumRequest implements Serializable {

    private static final long serialVersionUID = -440683620473003089L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;
}
