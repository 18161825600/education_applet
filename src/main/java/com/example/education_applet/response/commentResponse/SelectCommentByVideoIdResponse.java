package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectCommentByVideoIdResponse implements Serializable {
    private static final long serialVersionUID = 6721751459429374573L;

    private List<CommentByVideoIdResponse> commentByVideoIdResponseList;

    private Integer total;
}
