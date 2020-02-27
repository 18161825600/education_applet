package com.example.education_applet.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoomIdAndUserIdRequest implements Serializable {
    private static final long serialVersionUID = 6599070615537817569L;

    @ApiModelProperty(value = "房间id")
    private Long userId;

    @ApiModelProperty(value = "用户id")
    private Long roomId;
}
