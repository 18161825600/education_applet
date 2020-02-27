package com.example.education_applet.request;

/**
 * id请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class IdRequest implements Serializable {

    private static final long serialVersionUID = 5876339503536723966L;

    @ApiModelProperty(value = "主键id")
    private Long id;
}
