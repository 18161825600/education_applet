package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateRoomPictureRequest implements Serializable {
    private static final long serialVersionUID = 6193228703141094021L;

    private Long id;

    private String roomPicture;
}
