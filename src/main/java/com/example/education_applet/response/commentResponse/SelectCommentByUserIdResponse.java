package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectCommentByUserIdResponse implements Serializable {
    private static final long serialVersionUID = -749256467876875637L;

    private List<CommentByUserIdResponse> commentByUserIdResponseList;

    private Integer total;
}
