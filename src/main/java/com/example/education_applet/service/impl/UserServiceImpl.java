package com.example.education_applet.service.impl;

import com.example.education_applet.config.Configure;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.userRequest.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.userResponse.LoginUserResponse;
import com.example.education_applet.response.userResponse.SelectAllUserResponse;
import com.example.education_applet.response.userResponse.SelectUserResponse;
import com.example.education_applet.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            user.setIntegral(10);
            user.setCreateTime(new Date());
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
    public Integer updateUserBaseInfo(UpdateUserBaseInfoRequest updateUserBaseInfoRequest) {
        User user = userDao.selectUserById(updateUserBaseInfoRequest.getId());
        user.setNickName(updateUserBaseInfoRequest.getNickName());
        user.setHeadUrl(updateUserBaseInfoRequest.getHeadUrl());
        user.setPhoneNum(updateUserBaseInfoRequest.getPhoneNum());
        user.setUpdateTime(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public User findUserByOpenId(String openId) {
        User user = userDao.selectUserByOpenId(openId);
        return user;
    }

    @Override
    public SelectAllUserResponse selectAllUser(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<User> users = userDao.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        List<User> userList = pageInfo.getList();
        SelectAllUserResponse selectAllUserResponse = new SelectAllUserResponse();
        List<SelectUserResponse> list = new ArrayList<>();
        for (User user : userList) {
            SelectUserResponse selectUserResponse = new SelectUserResponse();
            BeanUtils.copyProperties(user,selectUserResponse);
            list.add(selectUserResponse);
        }
        selectAllUserResponse.setSelectUserResponseList(list);
        selectAllUserResponse.setTotal(userDao.countAllUser());
        return selectAllUserResponse;
    }
}
