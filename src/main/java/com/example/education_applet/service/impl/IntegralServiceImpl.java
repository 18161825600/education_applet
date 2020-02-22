package com.example.education_applet.service.impl;

import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.*;
import com.example.education_applet.response.*;
import com.example.education_applet.service.IntegralService;
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
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralDao integralDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer insertIntegral(UserIdRequest userIdRequest) {
        Integral integral = new Integral();
        integral.setUserId(userIdRequest.getUserId());
        integral.setGetIntegralNum(5);
        integral.setGetIntegralWay("签到");
        integral.setCreateTime(new Date());
        return integralDao.insertIntegral(integral);
    }

    @Override
    public SelectIntegralByUserIdResponse selectIntegralByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectIntegralByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectIntegralByUserIdResponse selectIntegralByUserIdResponse = changeSelectIntegralByUserIdResponse(integralList);
        selectIntegralByUserIdResponse.setTotal(integralDao.countIntegralByUserId(userIdAndPageNumRequest.getUserId()));
        return selectIntegralByUserIdResponse;
    }

    @Override
    public SelectIntegralByGetWayRsponse selectIntegralByGetWay(SelectIntegralByGetWayRequest selectIntegralByGetWayRequest) {
        PageHelper.startPage(1,selectIntegralByGetWayRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectIntegralByGetWay(selectIntegralByGetWayRequest.getGetWay());
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectIntegralByGetWayRsponse selectIntegralByGetWayRsponse = new SelectIntegralByGetWayRsponse();
        List<IntegralByGetWayResponse> list = new ArrayList<>();
        for (Integral integral : integralList) {
            IntegralByGetWayResponse integralByGetWayResponse = new IntegralByGetWayResponse();
            integralByGetWayResponse.setGetIntegralNum(integral.getGetIntegralNum());
            integralByGetWayResponse.setCreateTime(integral.getCreateTime());

            User user = userDao.selectUserById(integral.getUserId());
            integralByGetWayResponse.setNickName(user.getNickName());

            list.add(integralByGetWayResponse);
        }
        selectIntegralByGetWayRsponse.setIntegralByGetWayResponseList(list);
        selectIntegralByGetWayRsponse.setTotal(integralDao.countIntegralByGetWay(selectIntegralByGetWayRequest.getGetWay()));
        return selectIntegralByGetWayRsponse;
    }

    @Override
    public SelectIntegralByUserIdResponse selectIntegralByUserIdAndGetWay(SelectIntegralByUserIdAndGetWayRequest selectIntegralByUserIdAndGetWayRequest) {
        PageHelper.startPage(1,selectIntegralByUserIdAndGetWayRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectIntegralByUserIdAndGetWay(selectIntegralByUserIdAndGetWayRequest.getUserId(), selectIntegralByUserIdAndGetWayRequest.getGetIntegralWay());
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectIntegralByUserIdResponse selectIntegralByUserIdResponse = changeSelectIntegralByUserIdResponse(integralList);
        selectIntegralByUserIdResponse.setTotal(integralDao.countIntegralByUserIdAndGetWay(selectIntegralByUserIdAndGetWayRequest.getUserId(),selectIntegralByUserIdAndGetWayRequest.getGetIntegralWay()));
        return selectIntegralByUserIdResponse;
    }

    @Override
    public SelectAllIntegralResponse selectAllIntegral(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectAllIntegral();
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectAllIntegralResponse selectAllIntegralResponse = new SelectAllIntegralResponse();
        List<AllIntegralResponse> list = new ArrayList<>();
        for (Integral integral : integralList) {
            AllIntegralResponse allIntegralResponse = new AllIntegralResponse();
            BeanUtils.copyProperties(integral,allIntegralResponse);

            User user = userDao.selectUserById(integral.getUserId());
            allIntegralResponse.setNickName(user.getNickName());

            list.add(allIntegralResponse);
        }
        selectAllIntegralResponse.setAllIntegralResponseList(list);
        selectAllIntegralResponse.setTotal(integralDao.countAllIntegral());
        return selectAllIntegralResponse;
    }

    private SelectIntegralByUserIdResponse changeSelectIntegralByUserIdResponse(List<Integral> integralList){
        SelectIntegralByUserIdResponse selectIntegralByUserIdResponse = new SelectIntegralByUserIdResponse();
        List<IntegralByUserIdResponse> list = new ArrayList<>();
        for (Integral integral : integralList) {
            IntegralByUserIdResponse integralByUserIdResponse = new IntegralByUserIdResponse();
            BeanUtils.copyProperties(integral,integralByUserIdResponse);
            list.add(integralByUserIdResponse);
        }
        selectIntegralByUserIdResponse.setIntegralByUserIdResponseList(list);
        return selectIntegralByUserIdResponse;
    }
}
