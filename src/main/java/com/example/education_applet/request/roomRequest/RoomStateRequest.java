package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoomStateRequest implements Serializable {
    private static final long serialVersionUID = -4256926806775600134L;

    @ApiModelProperty(value = "房间状态")
    private Short roomState;

    private Integer pageNum = 1;
}
