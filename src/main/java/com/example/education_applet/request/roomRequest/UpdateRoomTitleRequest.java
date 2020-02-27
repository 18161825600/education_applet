package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomTitleRequest implements Serializable {
    private static final long serialVersionUID = -1913685695242748261L;

    @ApiModelProperty(value = "房间id")
    private Long id;

    @ApiModelProperty(value = "房间标题")
    private String roomTitle;
}
