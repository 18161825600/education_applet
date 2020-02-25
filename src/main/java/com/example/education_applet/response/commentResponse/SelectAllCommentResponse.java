package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectAllCommentResponse implements Serializable {
    private static final long serialVersionUID = 4230128219445284196L;

    private List<AllCommentResponse> allCommentResponseList;

    private Integer total;
}
