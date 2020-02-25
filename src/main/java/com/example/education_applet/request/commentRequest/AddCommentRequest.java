package com.example.education_applet.request.commentRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddCommentRequest implements Serializable {
    private static final long serialVersionUID = 2432854251169344068L;

    private Long userId;

    private Long videoId;

    private String comment;
}
