package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomStateRequest implements Serializable {
    private static final long serialVersionUID = -4256926806775600134L;

    private Short roomState;

    private Integer pageNum = 1;
}
