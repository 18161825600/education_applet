package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomNameRequest implements Serializable {
    private static final long serialVersionUID = 4998070978158797233L;

    @ApiModelProperty(value = "房间id")
    private Long id;

    @ApiModelProperty(value = "房间名字")
    private String roomName;
}
