package com.example.education_applet.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomIdAndUserIdRequest implements Serializable {
    private static final long serialVersionUID = 6599070615537817569L;

    private Long userId;

    private Long roomId;
}
