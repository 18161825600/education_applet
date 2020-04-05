package com.example.education_applet.request.favoriteRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddFavoriteRequest implements Serializable {
    private static final long serialVersionUID = -5661484871723098214L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "视频id")
    private Long videoId;
}
