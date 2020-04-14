package com.example.education_applet.service.impl;

import com.example.education_applet.dao.FollowDao;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.RoomDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Follow;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.Room;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.followRequest.AddFollowRequest;
import com.example.education_applet.request.roomRequest.RoomIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.followResponse.*;
import com.example.education_applet.service.FollowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IntegralDao integralDao;

    @Override
    public Integer insertFollow(AddFollowRequest addFollowRequest) {
        Follow oldFollow = followDao.selectFollowByUserIdAndRoomId(addFollowRequest.getUserId(),addFollowRequest.getRoomId());
        if(oldFollow==null){
            Follow follow = new Follow();
            follow.setUserId(addFollowRequest.getUserId());
            follow.setRoomId(addFollowRequest.getRoomId());
            follow.setCreateTime(new Date());
            Integer integer = followDao.insertFollow(follow);
            if(integer==1) {
                String newFormat = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
                List<Follow> follows = followDao.selectFollowByUserId(addFollowRequest.getUserId());
                Integer count = 0;
                for (Follow follow1 : follows) {
                    String oldFormat = new SimpleDateFormat("yyyy-mm-dd").format(follow1.getCreateTime());
                    if(oldFormat.equals(newFormat)){
                        count = count +1;
                    }
                }
                //每天首次关注主播加五点积分
                if(count==1){
                    Integral integral = new Integral();
                    integral.setUserId(addFollowRequest.getUserId());
                    integral.setGetIntegralNum(5);
                    integral.setGetIntegralWay("关注");
                    integral.setCreateTime(new Date());
                    integralDao.insertIntegral(integral);

                    User user = userDao.selectUserById(addFollowRequest.getUserId());
                    user.setIntegral(user.getIntegral()+5);
                    user.setUpdateTime(new Date());
                    userDao.updateUser(user);
                }
            }
            return 1;
        }
        return 0;
    }

    @Override
    public Integer deleteFollow(IdsRequest idsRequest) {
        return followDao.deleteFollow(idsRequest.getIds());
    }

    @Override
    public SelectFollowByUserIdResponse selectFollowByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<Follow> follows = followDao.selectFollowByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<Follow> pageInfo = new PageInfo<>(follows);

        List<Follow> followList = pageInfo.getList();
        SelectFollowByUserIdResponse selectFollowByUserIdResponse = new SelectFollowByUserIdResponse();
        List<FollowByUserIdResponse> list = new ArrayList<>();
        for (Follow follow : followList) {
            FollowByUserIdResponse followByUserIdResponse = new FollowByUserIdResponse();

            Room room = roomDao.selectRoomById(follow.getRoomId());
            BeanUtils.copyProperties(room,followByUserIdResponse);
            followByUserIdResponse.setRoomId(follow.getRoomId());

            User user = userDao.selectUserById(follow.getUserId());
            followByUserIdResponse.setNickName(user.getNickName());
            followByUserIdResponse.setHeadUrl(user.getHeadUrl());

            followByUserIdResponse.setCreateTime(changeDate(follow.getCreateTime()));
            list.add(followByUserIdResponse);
        }
        selectFollowByUserIdResponse.setFollowByUserIdResponseList(list);
        selectFollowByUserIdResponse.setTotal(followDao.countFollowByUserId(userIdAndPageNumRequest.getUserId()));
        return selectFollowByUserIdResponse;
    }

    @Override
    public SelectFollowByRoomIdResponse selectFollowByRoomId(RoomIdAndPageNumRequest roomIdAndPageNumRequest) {
        PageHelper.startPage(1,roomIdAndPageNumRequest.getPageNum()*10);
        List<Follow> follows = followDao.selectFollowByRoomId(roomIdAndPageNumRequest.getRoomId());
        PageInfo<Follow> pageInfo = new PageInfo<>(follows);

        List<Follow> followList = pageInfo.getList();
        SelectFollowByRoomIdResponse selectFollowByRoomIdResponse = new SelectFollowByRoomIdResponse();
        List<FollowByRoomIdResponse> list = new ArrayList<>();
        for (Follow follow : followList) {
            FollowByRoomIdResponse followByRoomIdResponse = new FollowByRoomIdResponse();

            User user = userDao.selectUserById(follow.getUserId());
            BeanUtils.copyProperties(user,followByRoomIdResponse);

            followByRoomIdResponse.setCreateTime(changeDate(follow.getCreateTime()));
            list.add(followByRoomIdResponse);
        }
        selectFollowByRoomIdResponse.setFollowByRoomIdResponseList(list);
        selectFollowByRoomIdResponse.setTotal(followDao.countFollowByRoomId(roomIdAndPageNumRequest.getRoomId()));
        return selectFollowByRoomIdResponse;
    }

    @Override
    public AllFollowResponse selectAllFollow(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Follow> follows = followDao.selectAllFollow();
        PageInfo<Follow> pageInfo = new PageInfo<>(follows);

        List<Follow> followList = pageInfo.getList();
        AllFollowResponse allFollowResponse = new AllFollowResponse();
        List<FollowResponse> list = new ArrayList<>();
        for (Follow follow : followList) {
            FollowResponse followResponse = new FollowResponse();

            User user = userDao.selectUserById(follow.getUserId());
            BeanUtils.copyProperties(user,followResponse);

            Room room = roomDao.selectRoomById(follow.getRoomId());
            followResponse.setRoomName(room.getRoomName());
            followResponse.setRoomPicture(room.getRoomPicture());

            followResponse.setCreateTime(changeDate(follow.getCreateTime()));
            list.add(followResponse);
        }
        allFollowResponse.setFollowResponseList(list);
        allFollowResponse.setTotal(followDao.countAllFollow());
        return allFollowResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
