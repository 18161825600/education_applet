package com.example.education_applet.service.impl;

import com.example.education_applet.dao.FavoriteDao;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.VideoDao;
import com.example.education_applet.pojo.Favorite;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.Video;
import com.example.education_applet.request.favoriteRequest.AddFavoriteRequest;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.favoriteResponse.*;
import com.example.education_applet.service.FavoriteService;
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
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private IntegralDao integralDao;

    @Override
    public Integer insertFavorite(AddFavoriteRequest addFavoriteRequest) {
        Favorite oldFavorite = favoriteDao.selectFavoriteByUserIdAndVideoId(addFavoriteRequest.getUserId(),addFavoriteRequest.getVideoId());
        if(oldFavorite==null) {
            Favorite favorite = new Favorite();
            favorite.setUserId(addFavoriteRequest.getUserId());
            favorite.setVideoId(addFavoriteRequest.getVideoId());
            favorite.setCreateTime(new Date());
            Integer integer = favoriteDao.insertFavorite(favorite);
            if (integer == 1) {
                String newFormat = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
                List<Favorite> favorites = favoriteDao.selectFavoriteByUserId(addFavoriteRequest.getUserId());
                Integer count = 0;
                for (Favorite favorite1 : favorites) {
                    String createFormat = new SimpleDateFormat("yyyy-mm-dd").format(favorite1.getCreateTime());
                    if (newFormat.equals(createFormat)) {
                        count = count + 1;
                    }
                }
                //每天首次收藏加五点积分
                if (count == 1) {
                    Integral integral = new Integral();
                    integral.setUserId(addFavoriteRequest.getUserId());
                    integral.setGetIntegralNum(5);
                    integral.setGetIntegralWay("收藏");
                    integral.setCreateTime(new Date());
                    integralDao.insertIntegral(integral);

                    User user = userDao.selectUserById(addFavoriteRequest.getUserId());
                    user.setIntegral(user.getIntegral() + 5);
                    user.setUpdateTime(new Date());
                    userDao.updateUser(user);
                }
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Integer deleteFavorite(IdsRequest idsRequest) {
        return favoriteDao.deleteFavorite(idsRequest.getIds());
    }

    @Override
    public SelectFavoriteByUserIdResponse selectFavoriteByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<Favorite> favorites = favoriteDao.selectFavoriteByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<Favorite> pageInfo = new PageInfo<>(favorites);

        List<Favorite> favoriteList = pageInfo.getList();
        SelectFavoriteByUserIdResponse selectFavoriteByUserIdResponse = new SelectFavoriteByUserIdResponse();
        List<FavoriteByUserIdResponse> list = new ArrayList<>();
        for (Favorite favorite : favoriteList) {
            FavoriteByUserIdResponse favoriteByUserIdResponse = new FavoriteByUserIdResponse();

            Video video = videoDao.selectVideoById(favorite.getVideoId());
            BeanUtils.copyProperties(video,favoriteByUserIdResponse);
            favoriteByUserIdResponse.setVideoId(video.getId());
            favoriteByUserIdResponse.setId(favorite.getId());

            favoriteByUserIdResponse.setCreateTime(changeDate(favorite.getCreateTime()));
            list.add(favoriteByUserIdResponse);
        }
        selectFavoriteByUserIdResponse.setFavoriteByUserIdResponseList(list);
        selectFavoriteByUserIdResponse.setTotal(favoriteDao.countFavoriteByUserId(userIdAndPageNumRequest.getUserId()));
        return selectFavoriteByUserIdResponse;
    }

    @Override
    public SelectFavoriteByVideoIdResponse selectFavoriteByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,videoIdAndPageNumRequest.getPageNum()*10);
        List<Favorite> favorites = favoriteDao.selectFavoriteByVideoId(videoIdAndPageNumRequest.getVideoId());
        PageInfo<Favorite> pageInfo = new PageInfo<>(favorites);

        List<Favorite> favoriteList = pageInfo.getList();
        SelectFavoriteByVideoIdResponse selectFavoriteByVideoIdResponse = new SelectFavoriteByVideoIdResponse();
        List<FavoriteByVideoIdResponse> list = new ArrayList<>();
        for (Favorite favorite : favoriteList) {
            FavoriteByVideoIdResponse favoriteByVideoIdResponse = new FavoriteByVideoIdResponse();

            User user = userDao.selectUserById(favorite.getUserId());
            BeanUtils.copyProperties(user,favoriteByVideoIdResponse);
            favoriteByVideoIdResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
            favoriteByVideoIdResponse.setCreateTime(changeDate(favorite.getCreateTime()));

            list.add(favoriteByVideoIdResponse);
        }
        selectFavoriteByVideoIdResponse.setFavoriteByVideoIdResponseList(list);
        selectFavoriteByVideoIdResponse.setTotal(favoriteDao.countFavoriteByVideoId(videoIdAndPageNumRequest.getVideoId()));
        return selectFavoriteByVideoIdResponse;
    }

    @Override
    public AllFavoriteResponse selectAllFavorite(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Favorite> favorites = favoriteDao.selectAllFavorite();
        PageInfo<Favorite> pageInfo = new PageInfo<>(favorites);

        List<Favorite> favoriteList = pageInfo.getList();
        AllFavoriteResponse allFavoriteResponse = new AllFavoriteResponse();
        List<FavoriteResponse> list = new ArrayList<>();
        for (Favorite favorite : favoriteList) {
            FavoriteResponse favoriteResponse = new FavoriteResponse();

            User user = userDao.selectUserById(favorite.getUserId());
            BeanUtils.copyProperties(user,favoriteResponse);
            favoriteResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

            Video video = videoDao.selectVideoById(favorite.getVideoId());
            favoriteResponse.setVideoName(video.getVideoName());
            favoriteResponse.setVideoPicture(video.getVideoPicture());
            favoriteResponse.setIsVipVideo(video.getIsVipVideo());

            favoriteResponse.setCreateTime(changeDate(favorite.getCreateTime()));
            list.add(favoriteResponse);
        }
        allFavoriteResponse.setFavoriteResponseList(list);
        allFavoriteResponse.setTotal(favoriteDao.countAllFavorite());
        return allFavoriteResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
