package com.example.education_applet.response.roomResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomByIdResponse implements Serializable {
    private static final long serialVersionUID = -216245189556459371L;

    private String roomName;

    private String pullUrl;

    private String roomTitle;

    private String roomPicture;

    //主播的昵称
    private String nickName;

    //主播的头像
    private String headUrl;

}
