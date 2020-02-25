package com.example.education_applet.service.impl;

import com.example.education_applet.dao.GetPrizeDao;
import com.example.education_applet.dao.PrizeDao;
import com.example.education_applet.dao.UserDao;
import com.example.education_applet.pojo.GetPrize;
import com.example.education_applet.pojo.Prize;
import com.example.education_applet.pojo.User;
import com.example.education_applet.request.*;
import com.example.education_applet.request.getPrizeRequest.AddGetPrizeRequest;
import com.example.education_applet.request.prizeRequest.PrizeIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.getPrizeResponse.SelectAllGetPrizeResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByPrizeIdResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByUserIdResponse;
import com.example.education_applet.response.prizeResponse.GetAllPrizeResponse;
import com.example.education_applet.response.prizeResponse.GetPrizeByIdResponse;
import com.example.education_applet.response.prizeResponse.GetPrizeByPrizeIdResponse;
import com.example.education_applet.response.prizeResponse.GetPrizeByUserIdResponse;
import com.example.education_applet.service.GetPrizeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GetPrizeServiceImpl implements GetPrizeService {

    @Autowired
    private GetPrizeDao getPrizeDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PrizeDao prizeDao;

    @Override
    public Integer insertGetPrize(AddGetPrizeRequest addGetPrizeRequest) {
        User user = userDao.selectUserById(addGetPrizeRequest.getUserId());
        Prize prize = prizeDao.selectPrizeById(addGetPrizeRequest.getPrizeId());

        if(user.getIntegral() >= prize.getPrizeIntegral()) {
            GetPrize getPrize = new GetPrize();
            getPrize.setPrizeId(addGetPrizeRequest.getPrizeId());
            getPrize.setUserId(addGetPrizeRequest.getUserId());
            getPrize.setPrizeNum(1);
            getPrize.setPrizeTotalIntegral(prize.getPrizeIntegral());
            getPrize.setCreateTime(new Date());
            Integer integer = getPrizeDao.insertGetPrize(getPrize);

            if(integer==1){
                user.setIntegral(user.getIntegral()-prize.getPrizeIntegral());
                user.setIsVip((short)1);
                user.setUpdateTime(new Date());

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                if(addGetPrizeRequest.getPrizeId().equals(1)){
                    calendar.roll(calendar.DAY_OF_YEAR,1);
                    user.setVipDueTime(calendar.getTime());
                }else if(addGetPrizeRequest.getPrizeId().equals(2)){
                    calendar.roll(calendar.DAY_OF_YEAR,3);
                    user.setVipDueTime(calendar.getTime());
                }else if(addGetPrizeRequest.getPrizeId().equals(3)){
                    calendar.roll(calendar.DAY_OF_YEAR,7);
                    user.setVipDueTime(calendar.getTime());
                }else if(addGetPrizeRequest.getPrizeId().equals(4)){
                    calendar.roll(calendar.DAY_OF_YEAR,30);
                    user.setVipDueTime(calendar.getTime());
                }
                userDao.updateUser(user);

                prize.setPrizeNum(prize.getPrizeNum()-1);
                prize.setUpdateTime(new Date());
                prizeDao.updatePrize(prize);
                return 1;

            }else return 0;//兑换失败
        } else return -1;//剩余积分不足
    }

    @Override
    public Integer deleteGetPrize(IdsRequest idsRequest) {
        return getPrizeDao.deleteGetPrize(idsRequest.getIds());
    }

    @Override
    public GetPrizeByIdResponse selectGetPrizeById(IdRequest idRequest) {
        GetPrize getPrize = getPrizeDao.selectGetPrizeById(idRequest.getId());
        GetPrizeByIdResponse getPrizeByIdResponse = new GetPrizeByIdResponse();
        BeanUtils.copyProperties(getPrize,getPrizeByIdResponse);

        User user = userDao.selectUserById(getPrize.getUserId());
        getPrizeByIdResponse.setNickName(user.getNickName());

        Prize prize = prizeDao.selectPrizeById(getPrize.getPrizeId());
        getPrizeByIdResponse.setPrizeName(prize.getPrizeName());
        getPrizeByIdResponse.setPrizeContent(prize.getPrizeContent());
        getPrizeByIdResponse.setPrizeIntegral(prize.getPrizeIntegral());
        return getPrizeByIdResponse;
    }

    @Override
    public SelectGetPrizeByUserIdResponse selectGetPrizeByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest) {
        PageHelper.startPage(1,userIdAndPageNumRequest.getPageNum()*10);
        List<GetPrize> getPrizes = getPrizeDao.selectGetPrizeByUserId(userIdAndPageNumRequest.getUserId());
        PageInfo<GetPrize> pageInfo = new PageInfo<>(getPrizes);

        List<GetPrize> getPrizeList = pageInfo.getList();
        SelectGetPrizeByUserIdResponse selectGetPrizeByUserIdResponse = new SelectGetPrizeByUserIdResponse();
        List<GetPrizeByUserIdResponse> list = new ArrayList<>();
        for (GetPrize getPrize : getPrizeList) {
            GetPrizeByUserIdResponse getPrizeByUserIdResponse = new GetPrizeByUserIdResponse();
            BeanUtils.copyProperties(getPrize,getPrizeByUserIdResponse);

            Prize prize = prizeDao.selectPrizeById(getPrize.getPrizeId());
            getPrizeByUserIdResponse.setPrizeName(prize.getPrizeName());

            list.add(getPrizeByUserIdResponse);
        }
        selectGetPrizeByUserIdResponse.setGetPrizeByUserIdResponseList(list);
        selectGetPrizeByUserIdResponse.setTotal(getPrizeDao.countGetPrizeByUserId(userIdAndPageNumRequest.getUserId()));
        return selectGetPrizeByUserIdResponse;
    }

    @Override
    public SelectGetPrizeByPrizeIdResponse selectGetPrizeByPrizeId(PrizeIdAndPageNumRequest prizeIdAndPageNumRequest) {
        PageHelper.startPage(1,prizeIdAndPageNumRequest.getPageNum()*10);
        List<GetPrize> getPrizes = getPrizeDao.selectGetPrizeByPrizeId(prizeIdAndPageNumRequest.getPrizeId());
        PageInfo<GetPrize> pageInfo = new PageInfo<>(getPrizes);

        List<GetPrize> getPrizeList = pageInfo.getList();
        SelectGetPrizeByPrizeIdResponse selectGetPrizeByPrizeIdResponse = new SelectGetPrizeByPrizeIdResponse();
        List<GetPrizeByPrizeIdResponse> list = new ArrayList<>();
        for (GetPrize getPrize : getPrizeList) {
            GetPrizeByPrizeIdResponse getPrizeByPrizeIdResponse = new GetPrizeByPrizeIdResponse();
            BeanUtils.copyProperties(getPrize,getPrizeByPrizeIdResponse);

            User user = userDao.selectUserById(getPrize.getUserId());
            getPrizeByPrizeIdResponse.setNickName(user.getNickName());

            list.add(getPrizeByPrizeIdResponse);
        }
        selectGetPrizeByPrizeIdResponse.setGetPrizeByPrizeIdResponseList(list);
        selectGetPrizeByPrizeIdResponse.setTotal(getPrizeDao.countGetPrizeByPrizeId(prizeIdAndPageNumRequest.getPrizeId()));
        return selectGetPrizeByPrizeIdResponse;
    }

    @Override
    public SelectAllGetPrizeResponse selectAllGetPrize(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<GetPrize> getPrizes = getPrizeDao.selectAllGetPrize();
        PageInfo<GetPrize> pageInfo = new PageInfo<>(getPrizes);

        List<GetPrize> prizeList = pageInfo.getList();
        SelectAllGetPrizeResponse selectAllGetPrizeResponse = new SelectAllGetPrizeResponse();
        List<GetAllPrizeResponse> list = new ArrayList<>();
        for (GetPrize getPrize : prizeList) {
            GetAllPrizeResponse getAllPrizeResponse = new GetAllPrizeResponse();
            BeanUtils.copyProperties(getPrize,getAllPrizeResponse);

            User user = userDao.selectUserById(getPrize.getUserId());
            getAllPrizeResponse.setNickName(user.getNickName());

            Prize prize = prizeDao.selectPrizeById(getPrize.getPrizeId());
            getAllPrizeResponse.setPrizeName(prize.getPrizeName());

            list.add(getAllPrizeResponse);
        }
        selectAllGetPrizeResponse.setGetAllPrizeResponseList(list);
        selectAllGetPrizeResponse.setTotal(getPrizeDao.countAllGetPrize());
        return selectAllGetPrizeResponse;
    }
}
