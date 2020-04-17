package com.example.education_applet.service.impl;

import com.example.education_applet.dao.IntegralDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.Integral;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.*;
import com.example.education_applet.request.integralRequest.SelectIntegralByGetWayRequest;
import com.example.education_applet.request.integralRequest.SelectIntegralByUserIdAndGetWayRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdRequest;
import com.example.education_applet.response.integralResponse.*;
import com.example.education_applet.service.IntegralService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralDao integralDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer insertIntegral(UserIdRequest userIdRequest) throws ParseException {
        List<Integral> integrals = integralDao.selectIntegralByUserIdAndGetWay(userIdRequest.getUserId(), "签到");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Integral lastIntegral = new Integral();
        String lastIntegralDate;
        if(!CollectionUtils.isEmpty(integrals)) {
            lastIntegral = integrals.get(integrals.size() - 1);
            lastIntegralDate= sdf.format(lastIntegral.getCreateTime());
        }else {
            lastIntegralDate="2000-01-01";
        }

        Date today = new Date();
        String todayDate = sdf.format(today);
        int i = distanceDay(sdf.parse(todayDate), sdf.parse(lastIntegralDate));
        if(i==0){//今天已经签到了
            return -1;
        }else {
            List<String> dateList = new ArrayList<>();
            for (Integral integral : integrals) {
                dateList.add(sdf.format(integral.getCreateTime()));
            }
            log.info("dateList-{}",dateList);

            Integral integral = new Integral();
            User user = userDao.selectUserById(userIdRequest.getUserId());

            Integer countCheckInDay = countCheckInDay(dateList);
            log.info("countCheckInDay-{}",countCheckInDay);
            if(0<=countCheckInDay && countCheckInDay<=7) {
                integral.setGetIntegralNum(5);
                user.setIntegral(user.getIntegral() + 5);
            }else {
                integral.setGetIntegralNum(10);
                user.setIntegral(user.getIntegral() + 10);
            }
            integral.setUserId(userIdRequest.getUserId());
            integral.setGetIntegralWay("签到");
            integral.setCreateTime(new Date());
            integralDao.insertIntegral(integral);

            user.setUpdateTime(new Date());
            userDao.updateUser(user);
            return 1;
        }
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
    public SelectIntegralByGetWayRsponse selectIntegralByGetWay(SelectIntegralByGetWayRequest selectIntegralByGetWayRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,selectIntegralByGetWayRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectIntegralByGetWay(selectIntegralByGetWayRequest.getGetWay());
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectIntegralByGetWayRsponse selectIntegralByGetWayRsponse = new SelectIntegralByGetWayRsponse();
        List<IntegralByGetWayResponse> list = new ArrayList<>();
        for (Integral integral : integralList) {
            IntegralByGetWayResponse integralByGetWayResponse = new IntegralByGetWayResponse();
            integralByGetWayResponse.setGetIntegralNum(integral.getGetIntegralNum());
            integralByGetWayResponse.setCreateTime(changeDate(integral.getCreateTime()));

            User user = userDao.selectUserById(integral.getUserId());
            integralByGetWayResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

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
    public SelectCheckInByUserIdResponse selectCheckInByUserId(UserIdRequest userIdRequest) throws ParseException {
        List<Integral> integrals = integralDao.selectIntegralByUserIdAndGetWay(userIdRequest.getUserId(), "签到");
        List<String> dateList = new ArrayList<>();
        for (Integral integral : integrals) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateList.add(sdf.format(integral.getCreateTime()));
        }

        SelectCheckInByUserIdResponse response = new SelectCheckInByUserIdResponse();
        response.setTotalDays(countCheckInDay(dateList));
        return response;
    }

    @Override
    public SelectAllIntegralResponse selectAllIntegral(PageNumRequest pageNumRequest) throws UnsupportedEncodingException {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Integral> integrals = integralDao.selectAllIntegral();
        PageInfo<Integral> pageInfo = new PageInfo<>(integrals);

        List<Integral> integralList = pageInfo.getList();
        SelectAllIntegralResponse selectAllIntegralResponse = new SelectAllIntegralResponse();
        List<AllIntegralResponse> list = new ArrayList<>();
        for (Integral integral : integralList) {
            AllIntegralResponse allIntegralResponse = new AllIntegralResponse();
            BeanUtils.copyProperties(integral,allIntegralResponse);
            allIntegralResponse.setCreateTime(changeDate(integral.getCreateTime()));

            User user = userDao.selectUserById(integral.getUserId());
            allIntegralResponse.setNickName(new String(Base64.decodeBase64(user.getNickName().getBytes()), "utf-8"));

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
            integralByUserIdResponse.setCreateTime(changeDate(integral.getCreateTime()));
            list.add(integralByUserIdResponse);
        }
        selectIntegralByUserIdResponse.setIntegralByUserIdResponseList(list);
        return selectIntegralByUserIdResponse;
    }

    private Integer countCheckInDay(List<String> dateList) throws ParseException {
        int count=1;
        boolean todaySignIn = false;

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String todays=sdf.format(today);

        for (int i = dateList.size() - 1; i >= 0; i--) {
            String date = dateList.get(i);
            int intervalDay = distanceDay(sdf.parse(todays), sdf.parse(date));
            if (intervalDay == 0) {
                todaySignIn = true;
            }else if (intervalDay == count) {
                count=count+1;
            }else {
                //不连续，终止判断
                break;
            }
        }
        if (!todaySignIn) {
            count=count-1;
        }
        return count;
    }

    //判断当天日期 与以往签到日期相隔天数
    private static int distanceDay(Date largeDay, Date smallDay) {
        int day = (int) ((largeDay.getTime() - smallDay.getTime()) / (1000 * 60 * 60 * 24));return day;
    }

    private String changeDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
