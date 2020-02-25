package com.example.education_applet.request.commentRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentIdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = 4132377835907464299L;

    private Long commentId;

    private Integer pageNum;
}
