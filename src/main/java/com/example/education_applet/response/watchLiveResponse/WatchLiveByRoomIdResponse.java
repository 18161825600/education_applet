package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WatchLiveByRoomIdResponse implements Serializable {
    private static final long serialVersionUID = 1133211337930853838L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private Date openTime;
}
