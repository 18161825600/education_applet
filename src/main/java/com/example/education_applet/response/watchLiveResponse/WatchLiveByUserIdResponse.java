package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WatchLiveByUserIdResponse implements Serializable {
    private static final long serialVersionUID = 5957114530664258352L;

    private String roomName;

    private String roomPicture;

    private Date openTime;
}
