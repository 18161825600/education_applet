package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomStateRequest implements Serializable {
    private static final long serialVersionUID = 4700149958241831939L;

    @ApiModelProperty(value = "房间id")
    private Long id;

    @ApiModelProperty(value = "0是未开播1是开播")
    private Short roomState;
}
