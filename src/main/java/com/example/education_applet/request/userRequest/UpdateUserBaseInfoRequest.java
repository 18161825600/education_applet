package com.example.education_applet.request.userRequest;

/**
 * 修改用户基础信息的请求
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserBaseInfoRequest implements Serializable {

    private static final long serialVersionUID = 645803194638786885L;

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "电话号")
    private String phoneNum;

    @ApiModelProperty(value = "头像")
    private String headUrl;
}
