package com.example.education_applet.request.ChatRecordRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelectChatRecordRequest implements Serializable {
    private static final long serialVersionUID = 7965372707116979621L;

    @ApiModelProperty(value = "房间id")
    private Long roomId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

}
