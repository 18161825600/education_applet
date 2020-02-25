package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FollowResponse implements Serializable {
    private static final long serialVersionUID = -6262042084435166037L;

    private String roomName;

    private String roomPicture;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private Date createTime;
}
