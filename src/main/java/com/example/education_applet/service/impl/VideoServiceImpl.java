package com.example.education_applet.service.impl;

import com.example.education_applet.dao.VideoDao;
import com.example.education_applet.pojo.Video;
import com.example.education_applet.request.*;
import com.example.education_applet.response.SelectVideoByIdResponse;
import com.example.education_applet.response.SelectVideoResponse;
import com.example.education_applet.response.VideoResponse;
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
    public SelectVideoByIdResponse selectVideoById(IdRequest idRequest) {
        Video video = videoDao.selectVideoById(idRequest.getId());
        SelectVideoByIdResponse selectVideoByIdResponse = new SelectVideoByIdResponse();
        BeanUtils.copyProperties(video,selectVideoByIdResponse);
        return selectVideoByIdResponse;
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
}
