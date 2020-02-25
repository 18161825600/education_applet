package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class FollowByIdResponse implements Serializable {
    private static final long serialVersionUID = 7525308954568533653L;

    private Long roomId;

    private String roomName;

    private String roomPicture;

    private String roomTitle;

    private String pullUrl;

    //主播的昵称
    private String nickName;

    //主播的头像
    private String headUrl;

}
