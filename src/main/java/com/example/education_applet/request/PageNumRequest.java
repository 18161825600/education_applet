package com.example.education_applet.request;

/**
 * 页数请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageNumRequest implements Serializable {

    private static final long serialVersionUID = -3835556372183275721L;

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;
}
