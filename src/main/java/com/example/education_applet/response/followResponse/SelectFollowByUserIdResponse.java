package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectFollowByUserIdResponse implements Serializable {
    private static final long serialVersionUID = -1155668302083914576L;

    private List<FollowByUserIdResponse> followByUserIdOpenResponseList;

    private List<FollowByUserIdResponse> followByUserIdCloseResponseList;

    private Integer total;
}
