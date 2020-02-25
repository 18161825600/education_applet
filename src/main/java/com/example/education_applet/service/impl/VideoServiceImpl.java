package com.example.education_applet.service.impl;

import com.example.education_applet.dao.*;
import com.example.education_applet.pojo.*;
import com.example.education_applet.request.*;
import com.example.education_applet.request.videoRequest.*;
import com.example.education_applet.response.commentResponse.CommentByVideoIdResponse;
import com.example.education_applet.response.videoResponse.SelectVideoByIdNotVipResponse;
import com.example.education_applet.response.videoResponse.SelectVideoByIdResponse;
import com.example.education_applet.response.videoResponse.SelectVideoResponse;
import com.example.education_applet.response.videoResponse.VideoResponse;
import com.example.education_applet.service.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public Integer insertVideo(AddVideoRequest addVideoRequest) {
        Video video = new Video();
        BeanUtils.copyProperties(addVideoRequest,video);
        video.setCreateTime(new Date());
        return videoDao.insertVideo(video);
    }

    @Override
    public Integer deleteVideo(IdsRequest idsRequest) {
        return videoDao.deleteVideo(idsRequest.getIds());
    }

    @Override
    public Integer updateVideoVip(UpdateVideoVipRequest updateVideoVipRequest) {
        Video video = videoDao.selectVideoById(updateVideoVipRequest.getId());
        video.setIsVipVideo(updateVideoVipRequest.getIsVipVideo());
        return videoDao.updateVideo(video);
    }

    @Override
    public <T>T selectVideoById(VideoIdAndUserIdRequest videoIdAndUserIdRequest) {
        Video video = videoDao.selectVideoById(videoIdAndUserIdRequest.getVideoId());
        User user = userDao.selectUserById(videoIdAndUserIdRequest.getUserId());
        if(user.getIsVip().equals((short)1) || (user.getIsVip().equals((short)0) && video.getIsVipVideo().equals(0))) {//vip用户可以看所有视频
            SelectVideoByIdResponse selectVideoByIdResponse = new SelectVideoByIdResponse();
            BeanUtils.copyProperties(video, selectVideoByIdResponse);

            List<Comment> comments = commentDao.selectCommentByVideoId(videoIdAndUserIdRequest.getVideoId());
            List<CommentByVideoIdResponse> list = changeCommentByVideoIdResponse(comments);
            selectVideoByIdResponse.setCommentByVideoIdResponseList(list);
            selectVideoByIdResponse.setFavoriteTotal(favoriteDao.countFavoriteByVideoId(videoIdAndUserIdRequest.getVideoId()));

            History history = new History();
            history.setVideoId(videoIdAndUserIdRequest.getVideoId());
            history.setUserId(videoIdAndUserIdRequest.getUserId());
            history.setCreateTime(new Date());
            historyDao.insertHistory(history);

            return (T)selectVideoByIdResponse;
        }else {
            SelectVideoByIdNotVipResponse selectVideoByIdNotVipResponse = new SelectVideoByIdNotVipResponse();
            BeanUtils.copyProperties(video,selectVideoByIdNotVipResponse);

            List<Comment> comments = commentDao.selectCommentByVideoId(videoIdAndUserIdRequest.getVideoId());
            List<CommentByVideoIdResponse> list = changeCommentByVideoIdResponse(comments);
            selectVideoByIdNotVipResponse.setCommentByVideoIdResponseList(list);
            selectVideoByIdNotVipResponse.setFavoriteTotal(favoriteDao.countFavoriteByVideoId(videoIdAndUserIdRequest.getVideoId()));

            return (T)selectVideoByIdNotVipResponse;
        }

    }

    @Override
    public SelectVideoResponse selectVideoByName(SelectVideoByNameRequest selectVideoByNameRequest) {
        PageHelper.startPage(1,selectVideoByNameRequest.getPageNum()*10);
        List<Video> videos = videoDao.selectVideoByName(selectVideoByNameRequest.getVideoName());
        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        List<Video> videoList = pageInfo.getList();
        SelectVideoResponse selectVideoResponse = changeVideoResponse(videoList);
        selectVideoResponse.setTotal(videoDao.countVideoByName(selectVideoByNameRequest.getVideoName()));
        return selectVideoResponse;
    }

    @Override
    public SelectVideoResponse selectVideoByType(SelectVideoByTypeRequest selectVideoByTypeRequest) {
        PageHelper.startPage(1,selectVideoByTypeRequest.getPageNum()*10);
        List<Video> videos = videoDao.selectVideoByType(selectVideoByTypeRequest.getVideoType());
        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        List<Video> videoList = pageInfo.getList();
        SelectVideoResponse selectVideoResponse = changeVideoResponse(videoList);
        selectVideoResponse.setTotal(videoDao.countVideoByType(selectVideoByTypeRequest.getVideoType()));
        return selectVideoResponse;
    }

    @Override
    public SelectVideoResponse selectVideoByVip(SelectVideoByVipRequest selectVideoByVipRequest) {
        PageHelper.startPage(1,selectVideoByVipRequest.getPageNum()*10);
        Short isVip ;
        if(selectVideoByVipRequest.getIsVipVideo().equals("会员")){
            isVip = (short)1;
        }else {
            isVip = (short)0;
        }
        List<Video> videos = videoDao.selectVideoByVip(isVip);
        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        List<Video> videoList = pageInfo.getList();
        SelectVideoResponse selectVideoResponse = changeVideoResponse(videoList);
        selectVideoResponse.setTotal(videoDao.countVideoByVip(isVip));
        return selectVideoResponse;
    }

    @Override
    public SelectVideoResponse selectAllVideo(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Video> videos = videoDao.selectAllVideo();
        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        List<Video> videoList = pageInfo.getList();
        SelectVideoResponse selectVideoResponse = changeVideoResponse(videoList);
        selectVideoResponse.setTotal(videoDao.countAllVideo());
        return selectVideoResponse;
    }

    private SelectVideoResponse changeVideoResponse(List<Video> videoList){
        SelectVideoResponse selectVideoResponse = new SelectVideoResponse();
        List<VideoResponse> list = new ArrayList<>();
        for (Video video : videoList) {
            VideoResponse videoResponse = new VideoResponse();
            BeanUtils.copyProperties(video,videoResponse);
            list.add(videoResponse);
        }
        selectVideoResponse.setVideoResponseList(list);
        return selectVideoResponse;
    }

    private List<CommentByVideoIdResponse> changeCommentByVideoIdResponse(List<Comment> comments){
        List<CommentByVideoIdResponse> list = new ArrayList<>();
        for (Comment comment : comments) {
            CommentByVideoIdResponse commentByVideoIdResponse = new CommentByVideoIdResponse();
            commentByVideoIdResponse.setComment(comment.getComment());
            commentByVideoIdResponse.setCreateTime(comment.getCreateTime());

            User commentUser = userDao.selectUserById(comment.getUserId());
            commentByVideoIdResponse.setNickName(commentUser.getNickName());
            commentByVideoIdResponse.setHeadUrl(commentUser.getHeadUrl());
            commentByVideoIdResponse.setIsVip(commentUser.getIsVip());

            list.add(commentByVideoIdResponse);
        }
        return list;
    }
}
