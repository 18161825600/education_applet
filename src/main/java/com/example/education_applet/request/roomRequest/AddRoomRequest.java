package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddRoomRequest implements Serializable {
    private static final long serialVersionUID = -4985121449735799037L;

    private Long userId;

    private String roomName;

    private String roomTitle;

    private String roomPicture;

    private String pushUrl;

    private String pullUrl;

}
