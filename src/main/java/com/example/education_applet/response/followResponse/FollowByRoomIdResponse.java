package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FollowByRoomIdResponse implements Serializable {
    private static final long serialVersionUID = -4849122531054613030L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String createTime;
}
