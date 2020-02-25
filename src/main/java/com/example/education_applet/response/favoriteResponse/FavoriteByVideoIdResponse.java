package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FavoriteByVideoIdResponse implements Serializable {
    private static final long serialVersionUID = -6528945058722654300L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private Date createTime;
}
