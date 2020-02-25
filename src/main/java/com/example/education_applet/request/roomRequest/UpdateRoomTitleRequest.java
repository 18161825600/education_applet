package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomTitleRequest implements Serializable {
    private static final long serialVersionUID = -1913685695242748261L;

    private Long id;

    private String roomTitle;
}
