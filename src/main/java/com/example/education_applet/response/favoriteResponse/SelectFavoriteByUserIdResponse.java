package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectFavoriteByUserIdResponse implements Serializable {
    private static final long serialVersionUID = -8511148551600716822L;

    private List<FavoriteByUserIdResponse> favoriteByUserIdResponseList;

    private Integer total;
}
