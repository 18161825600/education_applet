package com.example.education_applet.response.followResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class AllFollowResponse implements Serializable {
    private static final long serialVersionUID = 6571419354270986229L;

    private List<FollowResponse> followResponseList;

    private Integer total;
}
