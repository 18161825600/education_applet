package com.example.education_applet.service.impl;

import com.example.education_applet.config.Configure;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.OpenIdRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.userResponse.FindUserByOpenIdResponse;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;
import com.example.education_applet.response.userResponse.SelectUserResponse;
import com.example.education_applet.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private IntegralDao integralDao;


    @Override
    public Integer insertUser(User user) {
        user.setCreateTime(new Date());
        user.setIsVip((short)0);
        user.setUserPower((short)0);
        Integer integer = userDao.insertUser(user);
        User userByOpenId = userDao.selectUserByOpenId(user.getOpenId());
        if(integer==1) {
            //注册成功获得积分
            userByOpenId.setIntegral(10);
            userByOpenId.setCreateTime(new Date());
            userDao.updateUser(userByOpenId);

            //添加积分记录
            Integral integral = new Integral();
            integral.setUserId(userByOpenId.getId());
            integral.setGetIntegralNum(10);
            integral.setGetIntegralWay("注册");
            integral.setCreateTime(new Date());
            integralDao.insertIntegral(integral);
        }
        return 1;
    }

    @Override
    public Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest) throws UnsupportedEncodingException {
        User user = userDao.selectUserById(updateUserBaseInfoRequest.getId());
        user.setNickName(Base64.encodeBase64String(updateUserBaseInfoRequest.getNickName().getBytes("utf-8")));
        user.setHeadUrl(updateUserBaseInfoRequest.getHeadUrl());
        user.setPhoneNum(updateUserBaseInfoRequest.getPhoneNum());
        user.setUpdateTime(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public FindUserByOpenIdResponse findUserByOpenId(OpenIdRequest openIdRequest) throws UnsupportedEncodingException {
        User user = userDao.selectUserByOpenId(openIdRequest.getOpenId());
        FindUserByOpenIdResponse response = new FindUserByOpenIdResponse();
        BeanUtils.copyProperties(user,response);
        response.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
        if(user.getVipDueTime()==null){
            response.setVipDueTime(null);
        }else {
            response.setVipDueTime(changeDate(user.getVipDueTime()));
        }
        return response;
    }

    @Override
    public SelectUserResponse findUserById(UserIdRequest request) throws UnsupportedEncodingException {
        SelectUserResponse response = new SelectUserResponse();
        User user = userDao.selectUserById(request.getUserId());
        BeanUtils.copyProperties(user,response);
        response.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
        response.setVipDueTime(changeDate(user.getVipDueTime()));
        response.setCreateTime(changeDate(user.getVipDueTime()));
        return response;
    }

    @Override
    public User userByOpenId(String openId) {
        return userDao.selectUserByOpenId(openId);
    }


    @Override
    public SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<User> users = userDao.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        List<User> userList = pageInfo.getList();
        SelectAllUserResponse selectAllUserResponse = new SelectAllUserResponse();
        List<SelectUserResponse> list = new ArrayList<>();
        for (User user : userList) {
            SelectUserResponse selectUserResponse = new SelectUserResponse();
            BeanUtils.copyProperties(user,selectUserResponse);
            selectUserResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));
            selectUserResponse.setCreateTime(changeDate(user.getCreateTime()));
            if(user.getVipDueTime()==null){
                selectUserResponse.setVipDueTime(null);
            }else {
                selectUserResponse.setVipDueTime(changeDate(user.getVipDueTime()));
            }
            list.add(selectUserResponse);
        }
        selectAllUserResponse.setSelectUserResponseList(list);
        selectAllUserResponse.setTotal(userDao.countAllUser());
        return selectAllUserResponse;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
