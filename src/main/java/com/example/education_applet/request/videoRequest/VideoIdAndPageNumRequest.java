package com.example.education_applet.request.videoRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class VideoIdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = 230955716642392398L;

    private Long videoId;

    private Integer pageNum = 1;

}
