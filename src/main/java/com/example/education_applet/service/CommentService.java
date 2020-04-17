package com.example.education_applet.service;

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

import java.io.UnsupportedEncodingException;

public interface CommentService {

    Integer insertComment(AddCommentRequest addCommentRequest);

    Integer deleteComment(IdsRequest idsRequest);

    Integer updateComment(UpdateCommentRequest updateCommentRequest);

    SelectCommentByUserIdResponse selectCommentByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectCommentByVideoIdResponse selectCommentByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest) throws UnsupportedEncodingException;

    SelectAllCommentResponse selectAllComment(PageNumRequest pageNumRequest) throws UnsupportedEncodingException;

}
