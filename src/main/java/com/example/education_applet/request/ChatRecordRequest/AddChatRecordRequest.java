package com.example.education_applet.request.ChatRecordRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddChatRecordRequest implements Serializable {
    private static final long serialVersionUID = 7569182873026145560L;

    private Long userId;

    private Long roomId;

    private String userMessage;
}
