package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectWatchLiveByUserIdResponse implements Serializable {
    private static final long serialVersionUID = 3124309994273142978L;

    private List<WatchLiveByUserIdResponse> watchLiveByUserIdResponseList;

    private Integer total;
}
