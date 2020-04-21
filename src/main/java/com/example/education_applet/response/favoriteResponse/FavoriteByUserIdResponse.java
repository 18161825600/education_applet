package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FavoriteByUserIdResponse implements Serializable {

    private static final long serialVersionUID = -5584820082594431110L;

    private Long videoId;

    private String videoName;

    private String videoPicture;

    private Short isVipVideo;

    private String createTime;
}
