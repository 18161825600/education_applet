package com.example.education_applet.response.favoriteResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AllFavoriteResponse implements Serializable {
    private static final long serialVersionUID = -5171986143157537190L;

    private List<FavoriteResponse> favoriteResponseList;

    private Integer total;
}
