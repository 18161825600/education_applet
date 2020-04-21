package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FollowByUserIdResponse implements Serializable {
    private static final long serialVersionUID = -8973353664253491522L;

    private Long id;

    private Long roomId;

    private String roomName;

    private String roomPicture;

    private String roomTitle;

    private String pullUrl;

    //主播的昵称
    private String nickName;

    //主播的头像
    private String headUrl;

    private String createTime;
}
