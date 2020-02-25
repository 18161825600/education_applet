package com.example.education_applet.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class VideoIdAndUserIdRequest implements Serializable {
    private static final long serialVersionUID = 6837396408026712110L;

    private Long videoId;

    private Long userId;
}
