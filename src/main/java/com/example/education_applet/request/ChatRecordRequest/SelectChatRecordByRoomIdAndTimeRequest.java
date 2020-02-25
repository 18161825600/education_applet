package com.example.education_applet.request.ChatRecordRequest;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelectChatRecordByRoomIdAndTimeRequest implements Serializable {
    private static final long serialVersionUID = 7965372707116979621L;

    private Long roomId;

    private Long userId;

}
