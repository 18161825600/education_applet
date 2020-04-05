package com.example.education_applet.request.commentRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCommentRequest implements Serializable {
    private static final long serialVersionUID = -5264064424724232073L;

    @ApiModelProperty(value = "评论的主键id")
    private Long id;

    @ApiModelProperty(value = "评论内容")
    private String comment;
}
