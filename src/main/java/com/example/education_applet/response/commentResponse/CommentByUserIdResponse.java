package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentByUserIdResponse implements Serializable {
    private static final long serialVersionUID = 3753404992574902127L;

    private String videoName;

    private String videoPicture;

    private Short isVipVideo;

    private String comment;
}
