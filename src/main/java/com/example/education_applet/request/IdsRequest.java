package com.example.education_applet.request;

/**
 * ids请求
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IdsRequest implements Serializable {

    private static final long serialVersionUID = 4327873039502417924L;

    @ApiModelProperty(value = "主键id的集合")
    private List<Long> ids;
}
