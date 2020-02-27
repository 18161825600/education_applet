package com.example.education_applet.request.ChatRecordRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddChatRecordRequest implements Serializable {
    private static final long serialVersionUID = 7569182873026145560L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "房间id")
    private Long roomId;

    @ApiModelProperty(value = "用户发送的消息")
    private String userMessage;
}
