package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectFavoriteByVideoIdResponse implements Serializable {
    private static final long serialVersionUID = 8003104489858203488L;

    private List<FavoriteByVideoIdResponse> favoriteByVideoIdResponseList;

    private Integer total;
}
