package com.example.education_applet.service.impl;

import com.example.education_applet.dao.RoomDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.dao.WatchLiveDao;
import com.example.education_applet.pojo.Room;
import com.example.education_applet.pojo.User;
import com.example.education_applet.pojo.WatchLive;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.RoomIdAndUserIdRequest;
import com.example.education_applet.request.roomRequest.*;
import com.example.education_applet.response.roomResponse.RoomByIdResponse;
import com.example.education_applet.response.roomResponse.RoomResponse;
import com.example.education_applet.response.roomResponse.SelectRoomResponse;
import com.example.education_applet.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WatchLiveDao watchLiveDao;

    @Override
    public Integer insertRoom(AddRoomRequest addRoomRequest) {
        Room room = new Room();
        BeanUtils.copyProperties(addRoomRequest,room);
        room.setRoomState((short)0);
        room.setCreateTime(new Date());
        room.setBeginShowTime(new Date());
        return roomDao.insertRoom(room);
    }

    @Override
    public Integer updateRoomState(UpdateRoomStateRequest updateRoomStateRequest) {
        Room room = roomDao.selectRoomById(updateRoomStateRequest.getId());
        room.setRoomState(updateRoomStateRequest.getRoomState());
        room.setUpdateTime(new Date());
        return roomDao.updateRoom(room);
    }

    @Override
    public Integer updateRoomName(UpdateRoomNameRequest updateRoomNameRequest) {
        Room room = roomDao.selectRoomById(updateRoomNameRequest.getId());
        room.setRoomName(updateRoomNameRequest.getRoomName());
        room.setUpdateTime(new Date());
        return roomDao.updateRoom(room);
    }

    @Override
    public Integer updateRoomTitle(UpdateRoomTitleRequest updateRoomTitleRequest) {
        Room room = roomDao.selectRoomById(updateRoomTitleRequest.getId());
        room.setRoomTitle(updateRoomTitleRequest.getRoomTitle());
        room.setUpdateTime(new Date());
        return roomDao.updateRoom(room);
    }

    @Override
    public Integer updateRoomPicture(UpdateRoomPictureRequest updateRoomPictureRequest) {
        Room room = roomDao.selectRoomById(updateRoomPictureRequest.getId());
        room.setRoomPicture(updateRoomPictureRequest.getRoomPicture());
        room.setUpdateTime(new Date());
        return roomDao.updateRoom(room);
    }

    @Override
    public RoomByIdResponse selectRoomById(RoomIdAndUserIdRequest roomIdAndUserIdRequest) {
        Room room = roomDao.selectRoomById(roomIdAndUserIdRequest.getRoomId());
        RoomByIdResponse roomByIdResponse = new RoomByIdResponse();
        BeanUtils.copyProperties(room,roomByIdResponse);

        User anchor = userDao.selectUserById(room.getUserId());
        roomByIdResponse.setNickName(anchor.getNickName());
        roomByIdResponse.setHeadUrl(anchor.getHeadUrl());

        WatchLive oldWatchLive = watchLiveDao.selectWatchLiveByUserIdAndRoomId(roomIdAndUserIdRequest.getUserId(), roomIdAndUserIdRequest.getRoomId());
        if(oldWatchLive==null){
            WatchLive watchLive = new WatchLive();
            watchLive.setUserId(roomIdAndUserIdRequest.getUserId());
            watchLive.setRoomId(roomIdAndUserIdRequest.getRoomId());
            watchLive.setOpenTime(new Date());
            watchLive.setReceiveTime(new Date());
            watchLiveDao.insertWatchLive(watchLive);
        }else {
            oldWatchLive.setOpenTime(new Date());
            oldWatchLive.setReceiveTime(new Date());
            watchLiveDao.updateWatchLive(oldWatchLive);
        }

        return roomByIdResponse;
    }

    @Override
    public SelectRoomResponse selectRoomByName(RoomNameRequest roomNameRequest) {
        PageHelper.startPage(1,roomNameRequest.getPageNum()*10);
        List<Room> rooms = roomDao.selectRoomByName(roomNameRequest.getRoomName());
        PageInfo<Room> pageInfo = new PageInfo<>(rooms);

        List<Room> roomList = pageInfo.getList();
        SelectRoomResponse selectRoomResponse = changeRoomResponse(roomList);
        selectRoomResponse.setTotal(roomDao.countRoomByName(roomNameRequest.getRoomName()));

        return selectRoomResponse;
    }

    @Override
    public SelectRoomResponse selectRoomByState(RoomStateRequest roomStateRequest) {
        PageHelper.startPage(1,roomStateRequest.getPageNum()*10);
        List<Room> rooms = roomDao.selectRoomByState(roomStateRequest.getRoomState());
        PageInfo<Room> pageInfo = new PageInfo<>(rooms);

        List<Room> roomList = pageInfo.getList();
        SelectRoomResponse selectRoomResponse = changeRoomResponse(roomList);
        selectRoomResponse.setTotal(roomDao.countRoomByState(roomStateRequest.getRoomState()));
        return selectRoomResponse;
    }

    @Override
    public SelectRoomResponse selectAllRoom(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Room> rooms = roomDao.selectAllRoom();
        PageInfo<Room> pageInfo = new PageInfo<>(rooms);

        List<Room> roomList = pageInfo.getList();
        SelectRoomResponse selectRoomResponse = changeRoomResponse(roomList);
        selectRoomResponse.setTotal(roomDao.countAllRoom());
        return selectRoomResponse;
    }

    private SelectRoomResponse changeRoomResponse(List<Room> roomList){
        SelectRoomResponse selectRoomResponse = new SelectRoomResponse();
        List<RoomResponse> list = new ArrayList<>();
        for (Room room : roomList) {
            RoomResponse roomResponse = new RoomResponse();
            BeanUtils.copyProperties(room,roomResponse);

            list.add(roomResponse);
        }
        selectRoomResponse.setRoomResponseList(list);
        return selectRoomResponse;
    }

}
