package com.example.education_applet.request.commentRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCommentRequest implements Serializable {
    private static final long serialVersionUID = -5264064424724232073L;

    private Long id;

    private String comment;
}
