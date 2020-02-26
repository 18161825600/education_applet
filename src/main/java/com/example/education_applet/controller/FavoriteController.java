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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户收藏喜欢的视频")
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @ApiOperation(value = "通过用户id和视频id收藏视频")
    @PostMapping(value = "insert/favorite")
    public EducationJsonResult<String> insertFavorite(@RequestBody AddFavoriteRequest addFavoriteRequest){
        Integer integer = favoriteService.insertFavorite(addFavoriteRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过收藏的主键id批量删除收藏")
    @PostMapping(value = "delete/favorite")
    public EducationJsonResult<Integer> deleteFavorite(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(favoriteService.deleteFavorite(idsRequest));
    }

    @ApiOperation(value = "通过用户id查看该用户的所有收藏")
    @PostMapping(value = "select/favorite/by/userId")
    public EducationJsonResult<SelectFavoriteByUserIdResponse> selectFavoriteByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectFavoriteByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过视频id查看该视频被哪些用户收藏")
    @PostMapping(value = "select/favorite/by/videoId")
    public EducationJsonResult<SelectFavoriteByVideoIdResponse> selectFavoriteByVideoId(@RequestBody VideoIdAndPageNumRequest videoIdAndPageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectFavoriteByVideoId(videoIdAndPageNumRequest));
    }

    @ApiOperation(value = "查看数据库中的所有收藏记录")
    @PostMapping(value = "select/all/favorite")
    public EducationJsonResult<AllFavoriteResponse> selectAllFavorite(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(favoriteService.selectAllFavorite(pageNumRequest));
    }
}
