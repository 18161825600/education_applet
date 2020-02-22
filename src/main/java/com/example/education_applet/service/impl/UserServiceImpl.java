package com.example.education_applet.service.impl;

import com.example.education_applet.config.Configure;
import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.LoginUserRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.UpdateUserBaseInfoRequest;
import com.example.education_applet.response.LoginUserResponse;
import com.example.education_applet.response.SelectAllUserResponse;
import com.example.education_applet.response.SelectUserResponse;
import com.example.education_applet.service.UserService;
import com.example.education_applet.utils.HttpUtils;
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
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        String result = "";
        try{
            result = HttpUtils.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + Configure.mini_appID + "&secret="
                            + Configure.mini_secret + "&js_code="
                            + loginUserRequest.getCode()
                            + "&grant_type=authorization_code", null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.fromObject(result);
        String session_key = jsonObject.get("session_key").toString();
        String openId = jsonObject.get("openId").toString();
        User user = userDao.selectUserByOpenId(openId);
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        if(user!=null){
            BeanUtils.copyProperties(user,loginUserResponse);
            loginUserResponse.setSession_key(session_key);
            return loginUserResponse;
        }else {
            User insertUser = new User();
            insertUser.setOpenId(openId);
            insertUser.setIntegral(0);
            insertUser.setIsVip((short)0);
            insertUser.setUserPower((short)0);
            insertUser.setCreateTime(new Date());
            Integer integer = userDao.insertUser(insertUser);

            User user1 = userDao.selectUserByOpenId(openId);
            if(integer==1){
                //注册成功获得积分
                user1.setIntegral(10);
                userDao.updateUser(user1);

                Integral integral = new Integral();
                integral.setUserId(user1.getId());
                integral.setGetIntegralNum(10);
                integral.setGetIntegralWay("注册");
                integral.setCreateTime(new Date());
                integralDao.insertIntegral(integral);
            }

            BeanUtils.copyProperties(user1,loginUserResponse);
            loginUserResponse.setSession_key(session_key);
            return loginUserResponse;
        }
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
