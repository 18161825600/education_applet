package com.example.education_applet.request.followRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddFollowRequest implements Serializable {
    private static final long serialVersionUID = -3078979104631000497L;

    private Long userId;

    private Long roomId;
}
