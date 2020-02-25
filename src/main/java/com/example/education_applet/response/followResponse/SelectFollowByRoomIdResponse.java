package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectFollowByRoomIdResponse implements Serializable {
    private static final long serialVersionUID = 2775729112512841994L;

    private List<FollowByRoomIdResponse> followByRoomIdResponseList;

    private Integer total;
}
