package com.example.education_applet.request.favoriteRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddFavoriteRequest implements Serializable {
    private static final long serialVersionUID = -5661484871723098214L;

    private Long userId;

    private Long videoId;
}
