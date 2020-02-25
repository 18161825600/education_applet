package com.example.education_applet.response.ChatRecordResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectChatRecordByRoomIdAndTimeResponse implements Serializable {
    private static final long serialVersionUID = 3876149579407131228L;

    private List<ChatRecordByRoomIdAndTimeResponse> chatRecordList;
}
