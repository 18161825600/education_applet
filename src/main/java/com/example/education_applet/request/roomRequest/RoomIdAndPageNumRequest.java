package com.example.education_applet.request.roomRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoomIdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = -1296673434697712758L;

    @ApiModelProperty(value = "房间id")
    private Long roomId;

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;
}
