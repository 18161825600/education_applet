package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddRoomRequest implements Serializable {
    private static final long serialVersionUID = -4985121449735799037L;

    @ApiModelProperty(value = "主播id")
    private Long userId;

    @ApiModelProperty(value = "房间名")
    private String roomName;

    @ApiModelProperty(value = "房间标题")
    private String roomTitle;

    @ApiModelProperty(value = "封面图片")
    private String roomPicture;

    @ApiModelProperty(value = "推流地址")
    private String pushUrl;

    @ApiModelProperty(value = "拉流地址")
    private String pullUrl;

}
