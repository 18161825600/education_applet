package com.example.education_applet.response.roomResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomResponse implements Serializable {
    private static final long serialVersionUID = -8881508424352710029L;

    private String roomName;

    private String roomPicture;
}
