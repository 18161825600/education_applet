package com.example.education_applet.service.impl;

import com.example.education_applet.dao.RoomDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.WatchLiveDao;
import com.example.education_applet.pojo.Room;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.WatchLive;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.watchLiveResponse.*;
import com.example.education_applet.service.WatchLiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WatchLiveServiceImpl implements WatchLiveService {

    @Autowired
    private WatchLiveDao watchLiveDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;

    @Override
    public Integer deleteWatchLiva(IdsRequest idsRequest) {
        return watchLiveDao.deleteWatchLive(idsRequest.getIds());
    }

    @Override
    public SelectWatchLiveByUserIdResponse selectWatchLiveByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<WatchLive> watchLives = watchLiveDao.selectWatchLiveByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<WatchLive> pageInfo = new PageInfo<>(watchLives);

        List<WatchLive> watchLiveList = pageInfo.getList();
        SelectWatchLiveByUserIdResponse selectWatchLiveByUserIdResponse = new SelectWatchLiveByUserIdResponse();
        List<WatchLiveByUserIdResponse> list = new ArrayList<>();
        for (WatchLive watchLive : watchLiveList) {
            WatchLiveByUserIdResponse watchLiveByUserIdResponse = new WatchLiveByUserIdResponse();

            Room room = roomDao.selectRoomById(watchLive.getRoomId());
            BeanUtils.copyProperties(room,watchLiveByUserIdResponse);

            watchLiveByUserIdResponse.setOpenTime(changeDate(watchLive.getOpenTime()));
            list.add(watchLiveByUserIdResponse);
        }
        selectWatchLiveByUserIdResponse.setWatchLiveByUserIdResponseList(list);
        selectWatchLiveByUserIdResponse.setTotal(watchLiveDao.countWatchLiveByUserId(userIdAndPageNumRequest.getUserId()));
        return selectWatchLiveByUserIdResponse;
    }

    @Override
    public SelectWatchLiveByRoomIdResponse selectWatchLiveByRoomId(RoomIdAndPageNumRequest roomIdAndPageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,roomIdAndPageNumRequest.getPageNum()*10);
        List<WatchLive> watchLives = watchLiveDao.selectWatchLiveByRoomId(roomIdAndPageNumRequest.getRoomId());
        PageInfo<WatchLive> pageInfo = new PageInfo<>(watchLives);

        List<WatchLive> watchLiveList = pageInfo.getList();
        SelectWatchLiveByRoomIdResponse selectWatchLiveByRoomIdResponse = new SelectWatchLiveByRoomIdResponse();
        List<WatchLiveByRoomIdResponse> list = new ArrayList<>();
        for (WatchLive watchLive : watchLiveList) {
            WatchLiveByRoomIdResponse watchLiveByRoomIdResponse = new WatchLiveByRoomIdResponse();

            User user = userDao.selectUserById(watchLive.getUserId());
            BeanUtils.copyProperties(user,watchLiveByRoomIdResponse);
            watchLiveByRoomIdResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

            watchLiveByRoomIdResponse.setOpenTime(changeDate(watchLive.getOpenTime()));
            list.add(watchLiveByRoomIdResponse);
        }
        selectWatchLiveByRoomIdResponse.setWatchLiveByRoomIdResponseList(list);
        selectWatchLiveByRoomIdResponse.setTotal(watchLiveDao.countWatchLiveByRoomId(roomIdAndPageNumRequest.getRoomId()));
        return selectWatchLiveByRoomIdResponse;
    }

    @Override
    public AllWatchLiveResponse selectAllWatchLive(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<WatchLive> watchLives = watchLiveDao.selectAllWatchLive();
        PageInfo<WatchLive> pageInfo = new PageInfo<>(watchLives);

        List<WatchLive> watchLiveList = pageInfo.getList();
        AllWatchLiveResponse allWatchLiveResponse = new AllWatchLiveResponse();
        List<WatchLiveResponse> list = new ArrayList<>();
        for (WatchLive watchLive : watchLiveList) {
            WatchLiveResponse watchLiveResponse = new WatchLiveResponse();

            User user = userDao.selectUserById(watchLive.getUserId());
            BeanUtils.copyProperties(user,watchLiveResponse);
            watchLiveResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

            Room room = roomDao.selectRoomById(watchLive.getRoomId());
            watchLiveResponse.setRoomName(room.getRoomName());
            watchLiveResponse.setRoomPicture(room.getRoomPicture());

            watchLiveResponse.setOpenTime(changeDate(watchLive.getOpenTime()));

            list.add(watchLiveResponse);
        }
        allWatchLiveResponse.setWatchLiveResponseList(list);
        allWatchLiveResponse.setTotal(watchLiveDao.countAllWatchLive());
        return allWatchLiveResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
