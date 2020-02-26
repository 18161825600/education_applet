package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.commentRequest.AddCommentRequest;
import com.example.education_applet.request.commentRequest.UpdateCommentRequest;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.commentResponse.SelectAllCommentResponse;
import com.example.education_applet.response.commentResponse.SelectCommentByUserIdResponse;
import com.example.education_applet.response.commentResponse.SelectCommentByVideoIdResponse;
import com.example.education_applet.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户对视频的评论")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "通过用户id和视频id添加评论")
    @PostMapping(value = "insert/comment")
    public EducationJsonResult<String> insertComment(@RequestBody AddCommentRequest addCommentRequest){
        Integer integer = commentService.insertComment(addCommentRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过评论的主键id批量删除评论")
    @PostMapping(value = "delete/comment")
    public EducationJsonResult<String> deleteComment(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(commentService.deleteComment(idsRequest));
    }

    @ApiOperation(value = "通过评论的主键id修改评论")
    @PostMapping(value = "update/comment")
    public EducationJsonResult<String> updateComment(@RequestBody UpdateCommentRequest updateCommentRequest){
        Integer integer = commentService.updateComment(updateCommentRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过用户id查看该用户全部评论")
    @PostMapping(value = "select/comment/by/userId")
    public EducationJsonResult<SelectCommentByUserIdResponse> selectCommentByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(commentService.selectCommentByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过视频id查看该视频的全部评论")
    @PostMapping(value = "select/comment/by/videoId")
    public EducationJsonResult<SelectCommentByVideoIdResponse> selectCommentByVideoId(@RequestBody VideoIdAndPageNumRequest videoIdAndPageNumRequest){
        return EducationJsonResult.ok(commentService.selectCommentByVideoId(videoIdAndPageNumRequest));
    }

    @ApiOperation(value = "查看数据库中所有的评论")
    @PostMapping(value = "select/all/comment")
    public EducationJsonResult<SelectAllCommentResponse> selectAllComment(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(commentService.selectAllComment(pageNumRequest));
    }
}
