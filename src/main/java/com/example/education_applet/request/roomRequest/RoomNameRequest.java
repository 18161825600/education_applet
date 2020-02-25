package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomNameRequest implements Serializable {
    private static final long serialVersionUID = -3332388194124120806L;

    private String roomName;

    private Integer pageNum = 1;
}
