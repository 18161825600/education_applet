package com.example.education_applet.request.commentRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddCommentRequest implements Serializable {
    private static final long serialVersionUID = 2432854251169344068L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "视频id")
    private Long videoId;

    @ApiModelProperty(value = "评论")
    private String comment;
}
