package com.example.education_applet.response.commentResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommentByVideoIdResponse implements Serializable {

    private static final long serialVersionUID = -7865391872425347520L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String comment;

    private Date createTime;
}
