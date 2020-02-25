package com.example.education_applet.response.roomResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectRoomResponse implements Serializable {
    private static final long serialVersionUID = -6740224082394499308L;

    private List<RoomResponse> roomResponseList;

    private Integer total;
}
