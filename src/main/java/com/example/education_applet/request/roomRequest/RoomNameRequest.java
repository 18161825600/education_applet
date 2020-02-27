package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoomNameRequest implements Serializable {
    private static final long serialVersionUID = -3332388194124120806L;

    @ApiModelProperty(value = "房间名")
    private String roomName;

    private Integer pageNum = 1;
}
