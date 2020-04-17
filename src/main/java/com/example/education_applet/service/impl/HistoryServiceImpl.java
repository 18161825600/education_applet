package com.example.education_applet.service.impl;

import com.example.education_applet.dao.HistoryDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.VideoDao;
import com.example.education_applet.pojo.History;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.Video;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.historyResponse.*;
import com.example.education_applet.service.HistoryService;
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
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private VideoDao videoDao;

    @Override
    public Integer deleteHistory(IdsRequest idsRequest) {
        return historyDao.deleteHistory(idsRequest.getIds());
    }

    @Override
    public SelectHistoryByUserIdResponse selectHistoryByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<History> histories = historyDao.selectHistoryByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<History> pageInfo = new PageInfo<>(histories);

        List<History> historyList = pageInfo.getList();
        SelectHistoryByUserIdResponse selectHistoryByUserIdResponse = new SelectHistoryByUserIdResponse();
        List<HistoryByUserIdResponse> list = new ArrayList<>();
        for (History history : historyList) {
            HistoryByUserIdResponse historyByUserIdResponse = new HistoryByUserIdResponse();
            historyByUserIdResponse.setCreateTime(changeDate(history.getCreateTime()));

            Video video = videoDao.selectVideoById(history.getVideoId());
            historyByUserIdResponse.setVideoName(video.getVideoName());
            historyByUserIdResponse.setVideoPicture(video.getVideoPicture());

            list.add(historyByUserIdResponse);
        }
        selectHistoryByUserIdResponse.setHistoryByUserIdResponseList(list);
        selectHistoryByUserIdResponse.setTotal(historyDao.countHistoryByUserId(userIdAndPageNumRequest.getUserId()));
        return selectHistoryByUserIdResponse;
    }

    @Override
    public SelectHistoryByVideoIdResponse selectHistoryByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,videoIdAndPageNumRequest.getPageNum()*10);
        List<History> histories = historyDao.selectHistoryByVideoId(videoIdAndPageNumRequest.getVideoId());
        PageInfo<History> pageInfo = new PageInfo<>(histories);

        List<History> historyList = pageInfo.getList();
        SelectHistoryByVideoIdResponse selectHistoryByVideoIdResponse = new SelectHistoryByVideoIdResponse();
        List<HistoryByVideoIdResponse> list = new ArrayList<>();
        for (History history : historyList) {
            HistoryByVideoIdResponse historyByVideoIdResponse = new HistoryByVideoIdResponse();

            User user = userDao.selectUserById(history.getUserId());
            historyByVideoIdResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
            historyByVideoIdResponse.setHeadUrl(user.getHeadUrl());
            historyByVideoIdResponse.setIsVip(user.getIsVip());

            historyByVideoIdResponse.setCreateTime(changeDate(history.getCreateTime()));
            list.add(historyByVideoIdResponse);
        }
        selectHistoryByVideoIdResponse.setHistoryByVideoIdResponseList(list);
        selectHistoryByVideoIdResponse.setTotal(historyDao.countHistoryByVideoId(videoIdAndPageNumRequest.getVideoId()));
        return selectHistoryByVideoIdResponse;
    }

    @Override
    public AllHistoryResponse selectAllHistory(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<History> histories = historyDao.selectAllHistory();
        PageInfo<History> pageInfo = new PageInfo<>(histories);

        List<History> historyList = pageInfo.getList();
        AllHistoryResponse allHistoryResponse = new AllHistoryResponse();
        List<HistoryResponse> list = new ArrayList<>();
        for (History history : historyList) {
            HistoryResponse historyResponse = new HistoryResponse();
            User user = userDao.selectUserById(history.getUserId());
            BeanUtils.copyProperties(user,historyResponse);
            historyResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

            Video video = videoDao.selectVideoById(history.getVideoId());
            historyResponse.setVideoName(video.getVideoName());
            historyResponse.setVideoPicture(video.getVideoPicture());

            historyResponse.setCreateTime(changeDate(history.getCreateTime()));
            list.add(historyResponse);
        }
        allHistoryResponse.setHistoryResponseList(list);
        allHistoryResponse.setTotal(historyDao.countAllHistory());
        return allHistoryResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
