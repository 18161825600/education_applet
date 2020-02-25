package com.example.education_applet.response.watchLiveResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AllWatchLiveResponse implements Serializable {
    private static final long serialVersionUID = 7661146015331609163L;

    private List<WatchLiveResponse> watchLiveResponseList;

    private Integer total;
}
