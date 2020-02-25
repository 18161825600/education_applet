package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectWatchLiveByRoomIdResponse implements Serializable {
    private static final long serialVersionUID = -3264109228788272938L;

    private List<WatchLiveByRoomIdResponse> watchLiveByRoomIdResponseList;

    private Integer total;
}
