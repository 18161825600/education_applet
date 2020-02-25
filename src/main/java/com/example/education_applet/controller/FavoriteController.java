package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.favoriteRequest.AddFavoriteRequest;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.favoriteResponse.AllFavoriteResponse;
import com.example.education_applet.response.favoriteResponse.SelectFavoriteByUserIdResponse;
import com.example.education_applet.response.favoriteResponse.SelectFavoriteByVideoIdResponse;
import com.example.education_applet.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping(value = "insert/favorite")
    public EducationJsonResult<String> insertFavorite(@RequestBody AddFavoriteRequest addFavoriteRequest){
        Integer integer = favoriteService.insertFavorite(addFavoriteRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "delete/favorite")
    public EducationJsonResult<Integer> deleteFavorite(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(favoriteService.deleteFavorite(idsRequest));
    }

    @PostMapping(value = "select/favorite/by/userId")
    public EducationJsonResult<SelectFavoriteByUserIdResponse> selectFavoriteByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectFavoriteByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/favorite/by/videoId")
    public EducationJsonResult<SelectFavoriteByVideoIdResponse> selectFavoriteByVideoId(@RequestBody VideoIdAndPageNumRequest videoIdAndPageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectFavoriteByVideoId(videoIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/favorite")
    public EducationJsonResult<AllFavoriteResponse> selectAllFavorite(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectAllFavorite(pageNumRequest));
    }
}
