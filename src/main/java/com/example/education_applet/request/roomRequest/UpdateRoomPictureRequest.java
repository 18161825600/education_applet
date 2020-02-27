package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomPictureRequest implements Serializable {
    private static final long serialVersionUID = 6193228703141094021L;

    @ApiModelProperty(value = "房间id")
    private Long id;

    @ApiModelProperty(value = "封面图片")
    private String roomPicture;
}
