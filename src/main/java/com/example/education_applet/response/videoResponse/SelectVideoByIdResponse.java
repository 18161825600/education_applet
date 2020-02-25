package com.example.education_applet.response.videoResponse;

/**
 * 通过视频id查找视频的返回值
 */

import com.example.education_applet.response.commentResponse.CommentByVideoIdResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SelectVideoByIdResponse implements Serializable {

    private static final long serialVersionUID = 453704797841183061L;
    private String videoName;

    private Double videoSize;

    private String videoPicture;

    private String videoUrl;

    private String videoType;

    private String videoContent;

    private Short isVipVideo;

    private Date createTime;

    private List<CommentByVideoIdResponse> commentByVideoIdResponseList;

    private Integer favoriteTotal;
}
