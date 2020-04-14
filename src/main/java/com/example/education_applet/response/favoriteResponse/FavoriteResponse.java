package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FavoriteResponse implements Serializable {
    private static final long serialVersionUID = 5408197809587188800L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String videoName;

    private String videoPicture;

    private Short isVipVideo;

    private String createTime;
}
