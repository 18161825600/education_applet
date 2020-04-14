package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WatchLiveResponse implements Serializable {
    private static final long serialVersionUID = -4520832963199267652L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String roomName;

    private String roomPicture;

    private String openTime;
}
