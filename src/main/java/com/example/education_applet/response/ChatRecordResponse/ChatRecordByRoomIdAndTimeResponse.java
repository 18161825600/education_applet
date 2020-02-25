package com.example.education_applet.response.ChatRecordResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRecordByRoomIdAndTimeResponse implements Serializable {
    private static final long serialVersionUID = -8146939288699332526L;

    private String nickName;

    private Short isVip;

    private String userMessage;
}
