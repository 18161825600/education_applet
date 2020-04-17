package com.example.education_applet.service.impl;

import com.example.education_applet.dao.CommentDao;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.VideoDao;
import com.example.education_applet.pojo.Comment;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.Video;
import com.example.education_applet.request.commentRequest.AddCommentRequest;
import com.example.education_applet.request.commentRequest.UpdateCommentRequest;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.commentResponse.*;
import com.example.education_applet.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private IntegralDao integralDao;

    @Override
    public Integer insertComment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addCommentRequest,comment);
        comment.setCreateTime(new Date());
        Integer integer = commentDao.insertComment(comment);
        if(integer==1){
            String nowDate = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
            List<Comment> comments = commentDao.selectCommentByUserId(addCommentRequest.getUserId());
            Integer count = 0;
            for (Comment comment1 : comments) {
                String oldDate = new SimpleDateFormat("yyyy-mm-dd").format(comment1.getCreateTime());
                if(oldDate.equals(nowDate)){
                    count = count+1;
                }
            }
            //每天前三次评论加五点积分
            if(count<=3){

                Integral integral = new Integral();
                integral.setUserId(addCommentRequest.getUserId());
                integral.setGetIntegralNum(5);
                integral.setGetIntegralWay("评论");
                integral.setCreateTime(new Date());
                integralDao.insertIntegral(integral);

                User user = userDao.selectUserById(addCommentRequest.getUserId());
                user.setIntegral(user.getIntegral()+5);
                user.setUpdateTime(new Date());
                userDao.updateUser(user);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public Integer deleteComment(IdsRequest idsRequest) {
        return commentDao.deleteComment(idsRequest.getIds());
    }

    @Override
    public Integer updateComment(UpdateCommentRequest updateCommentRequest) {
        Comment comment = commentDao.selectCommentById(updateCommentRequest.getId());
        comment.setComment(updateCommentRequest.getComment());
        comment.setUpdateTime(new Date());
        return commentDao.updateComment(comment);
    }

    @Override
    public SelectCommentByUserIdResponse selectCommentByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<Comment> comments = commentDao.selectCommentByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);

        List<Comment> commentList = pageInfo.getList();
        SelectCommentByUserIdResponse selectCommentByUserIdResponse = new SelectCommentByUserIdResponse();
        List<CommentByUserIdResponse> list = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentByUserIdResponse commentByUserIdResponse = new CommentByUserIdResponse();
            commentByUserIdResponse.setComment(comment.getComment());

            Video video = videoDao.selectVideoById(comment.getVideoId());
            commentByUserIdResponse.setVideoName(video.getVideoName());
            commentByUserIdResponse.setVideoPicture(video.getVideoPicture());
            commentByUserIdResponse.setIsVipVideo(video.getIsVipVideo());

            list.add(commentByUserIdResponse);
        }
        selectCommentByUserIdResponse.setCommentByUserIdResponseList(list);
        selectCommentByUserIdResponse.setTotal(commentDao.countCommentByUserId(userIdAndPageNumRequest.getUserId()));
        return selectCommentByUserIdResponse;
    }

    @Override
    public SelectCommentByVideoIdResponse selectCommentByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,videoIdAndPageNumRequest.getPageNum()*10);
        List<Comment> comments = commentDao.selectCommentByVideoId(videoIdAndPageNumRequest.getVideoId());
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);

        List<Comment> commentList = pageInfo.getList();
        SelectCommentByVideoIdResponse selectCommentByVideoIdResponse = new SelectCommentByVideoIdResponse();
        List<CommentByVideoIdResponse> list = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentByVideoIdResponse commentByVideoIdResponse = new CommentByVideoIdResponse();

            User user = userDao.selectUserById(comment.getUserId());
            commentByVideoIdResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
            commentByVideoIdResponse.setHeadUrl(user.getHeadUrl());
            commentByVideoIdResponse.setIsVip(user.getIsVip());

            commentByVideoIdResponse.setComment(comment.getComment());
            commentByVideoIdResponse.setCreateTime(changeDate(comment.getCreateTime()));

            list.add(commentByVideoIdResponse);
        }
        selectCommentByVideoIdResponse.setCommentByVideoIdResponseList(list);
        selectCommentByVideoIdResponse.setTotal(commentDao.countCommentByVideoId(videoIdAndPageNumRequest.getVideoId()));
        return selectCommentByVideoIdResponse;
    }

    @Override
    public SelectAllCommentResponse selectAllComment(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Comment> comments = commentDao.selectAllComment();
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);

        List<Comment> commentList = pageInfo.getList();
        SelectAllCommentResponse selectAllCommentResponse = new SelectAllCommentResponse();
        List<AllCommentResponse> list = new ArrayList<>();
        for (Comment comment : commentList) {
            AllCommentResponse allCommentResponse = new AllCommentResponse();
            User user = userDao.selectUserById(comment.getUserId());
            BeanUtils.copyProperties(user,allCommentResponse);
            allCommentResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

            Video video = videoDao.selectVideoById(comment.getVideoId());
            allCommentResponse.setVideoName(video.getVideoName());
            allCommentResponse.setVideoPicture(video.getVideoPicture());
            allCommentResponse.setIsVipVideo(video.getIsVipVideo());

            allCommentResponse.setComment(comment.getComment());
            allCommentResponse.setCreateTime(changeDate(comment.getCreateTime()));

            list.add(allCommentResponse);
        }
        selectAllCommentResponse.setAllCommentResponseList(list);
        selectAllCommentResponse.setTotal(commentDao.countAllComment());
        return selectAllCommentResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
