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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "insert/comment")
    public EducationJsonResult<String> insertComment(@RequestBody AddCommentRequest addCommentRequest){
        Integer integer = commentService.insertComment(addCommentRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "delete/comment")
    public EducationJsonResult<String> deleteComment(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(commentService.deleteComment(idsRequest));
    }

    @PostMapping(value = "update/comment")
    public EducationJsonResult<String> updateComment(@RequestBody UpdateCommentRequest updateCommentRequest){
        Integer integer = commentService.updateComment(updateCommentRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "select/comment/by/userId")
    public EducationJsonResult<SelectCommentByUserIdResponse> selectCommentByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(commentService.selectCommentByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/comment/by/videoId")
    public EducationJsonResult<SelectCommentByVideoIdResponse> selectCommentByVideoId(@RequestBody VideoIdAndPageNumRequest videoIdAndPageNumRequest){
        return EducationJsonResult.ok(commentService.selectCommentByVideoId(videoIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/comment")
    public EducationJsonResult<SelectAllCommentResponse> selectAllComment(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(commentService.selectAllComment(pageNumRequest));
    }
}
