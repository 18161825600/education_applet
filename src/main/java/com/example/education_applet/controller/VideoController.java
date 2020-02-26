package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.*;
import com.example.education_applet.request.videoRequest.*;
import com.example.education_applet.response.videoResponse.SelectVideoByIdResponse;
import com.example.education_applet.response.videoResponse.SelectVideoResponse;
import com.example.education_applet.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "视频")
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "添加视频")
    @PostMapping(value = "insert/video")
    public EducationJsonResult<String> insertVideo(@RequestBody AddVideoRequest addVideoRequest){
        Integer integer = videoService.insertVideo(addVideoRequest);
        if(integer==0){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过视频的主键id批量删除视频")
    @PostMapping(value = "delete/video")
    public EducationJsonResult<String> deleteVideo(@RequestBody IdsRequest idsRequest){
        Integer integer = videoService.deleteVideo(idsRequest);
        if(integer==0){
            return EducationJsonResult.errorMsg("false");
        }else return EducationJsonResult.ok(integer);
    }

    @ApiOperation(value = "通过视频的id修改视频是不是vip视频")
    @PostMapping(value = "update/video/vip")
    public EducationJsonResult<String> updateVideoVip(@RequestBody UpdateVideoVipRequest updateVideoVipRequest){
        Integer integer = videoService.updateVideoVip(updateVideoVipRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过视频的id查看视频的详情")
    @PostMapping(value = "select/video/by/id")
    public <T>T selectVideoById(@RequestBody VideoIdAndUserIdRequest videoIdAndUserIdRequest){
        return (T)EducationJsonResult.ok(videoService.selectVideoById(videoIdAndUserIdRequest));
    }

    @ApiOperation(value = "通过视频的名字模糊查找视频")
    @PostMapping(value = "select/video/by/name")
    public EducationJsonResult<SelectVideoResponse> selectVideoByName(@RequestBody SelectVideoByNameRequest selectVideoByNameRequest){
        return EducationJsonResult.ok(videoService.selectVideoByName(selectVideoByNameRequest));
    }

    @ApiOperation(value = "通过视频的类型查找视频")
    @PostMapping(value = "select/video/by/type")
    public EducationJsonResult<SelectVideoResponse> selectVideoByType(@RequestBody SelectVideoByTypeRequest selectVideoByTypeRequest){
        return EducationJsonResult.ok(videoService.selectVideoByType(selectVideoByTypeRequest));
    }

    @ApiOperation(value = "通过视频是不是vip视频查找视频")
    @PostMapping(value = "select/video/by/isVip")
    public EducationJsonResult<SelectVideoResponse> selectVideoByVip(@RequestBody SelectVideoByVipRequest selectVideoByVipRequest){
        return EducationJsonResult.ok(videoService.selectVideoByVip(selectVideoByVipRequest));
    }

    @ApiOperation(value = "查找全部视频")
    @PostMapping(value = "select/all/video")
    public EducationJsonResult<SelectVideoResponse> selectAllVideo(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(videoService.selectAllVideo(pageNumRequest));
    }
}
