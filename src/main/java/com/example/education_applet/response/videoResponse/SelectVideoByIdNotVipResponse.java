package com.example.education_applet.response.videoResponse;

import com.example.education_applet.response.commentResponse.CommentByVideoIdResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SelectVideoByIdNotVipResponse implements Serializable {
    private static final long serialVersionUID = 1167538103350654893L;

    private String videoName;

    private Double videoSize;

    private String videoPicture;

    private String videoType;

    private String videoContent;

    private Short isVipVideo;

    private Date createTime;

    private List<CommentByVideoIdResponse> commentByVideoIdResponseList;

    private Integer favoriteTotal;
}
