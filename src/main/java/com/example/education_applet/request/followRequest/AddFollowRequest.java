package com.example.education_applet.request.followRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddFollowRequest implements Serializable {
    private static final long serialVersionUID = -3078979104631000497L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "房间id")
    private Long roomId;
}
