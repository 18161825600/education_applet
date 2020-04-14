package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AllCommentResponse implements Serializable {
    private static final long serialVersionUID = 3230201648118073194L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String videoName;

    private String videoPicture;

    private Short isVipVideo;

    private String comment;

    private String createTime;
}
