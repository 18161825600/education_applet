package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomNameRequest implements Serializable {
    private static final long serialVersionUID = 4998070978158797233L;

    private Long id;

    private String roomName;
}
