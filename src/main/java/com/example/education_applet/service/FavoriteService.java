package com.example.education_applet.service;

import com.example.education_applet.request.favoriteRequest.AddFavoriteRequest;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.favoriteResponse.AllFavoriteResponse;
import com.example.education_applet.response.favoriteResponse.SelectFavoriteByUserIdResponse;
import com.example.education_applet.response.favoriteResponse.SelectFavoriteByVideoIdResponse;

public interface FavoriteService {

    Integer insertFavorite(AddFavoriteRequest addFavoriteRequest);

    Integer deleteFavorite(IdsRequest idsRequest);

    SelectFavoriteByUserIdResponse selectFavoriteByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectFavoriteByVideoIdResponse selectFavoriteByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest);

    AllFavoriteResponse selectAllFavorite(PageNumRequest pageNumRequest);
}
