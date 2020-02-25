package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomStateRequest implements Serializable {
    private static final long serialVersionUID = 4700149958241831939L;

    private Long id;

    private Short roomState;
}
