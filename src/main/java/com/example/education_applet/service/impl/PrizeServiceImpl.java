package com.example.education_applet.service.impl;

import com.example.education_applet.dao.PrizeDao;
import com.example.education_applet.pojo.Prize;
import com.example.education_applet.request.*;
import com.example.education_applet.request.prizeRequest.AddPrizeRequest;
import com.example.education_applet.request.prizeRequest.UpdatePrizeRequest;
import com.example.education_applet.response.prizeResponse.PrizeByIdResponse;
import com.example.education_applet.response.prizeResponse.PrizeResponse;
import com.example.education_applet.response.prizeResponse.SelectPrizeResponse;
import com.example.education_applet.service.PrizeService;
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
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeDao prizeDao;

    @Override
    public Integer insertPrize(AddPrizeRequest addPrizeRequest) {
        Prize prize = new Prize();
        BeanUtils.copyProperties(addPrizeRequest,prize);
        prize.setCreateTime(new Date());
        return prizeDao.insertPrize(prize);
    }

    @Override
    public Integer deletePrize(IdsRequest idsRequest) {
        return prizeDao.deletePrize(idsRequest.getIds());
    }

    @Override
    public Integer updatePrize(UpdatePrizeRequest updatePrizeRequest) {
        Prize prize = prizeDao.selectPrizeById(updatePrizeRequest.getId());
        BeanUtils.copyProperties(updatePrizeRequest,prize);
        prize.setUpdateTime(new Date());
        return prizeDao.updatePrize(prize);
    }

    @Override
    public PrizeByIdResponse selectPrizeById(IdRequest idRequest) {
        Prize prize = prizeDao.selectPrizeById(idRequest.getId());
        PrizeByIdResponse prizeByIdResponse = new PrizeByIdResponse();
        BeanUtils.copyProperties(prize,prizeByIdResponse);
        return prizeByIdResponse;
    }

    @Override
    public SelectPrizeResponse selectAllPrize(PageNumRequest pageNumRequest) {
        PageHelper.startPage(1,pageNumRequest.getPageNum()*10);
        List<Prize> prizes = prizeDao.selectAllPrize();
        PageInfo<Prize> pageInfo = new PageInfo<>(prizes);

        List<Prize> prizeList = pageInfo.getList();
        SelectPrizeResponse selectPrizeResponse = new SelectPrizeResponse();
        List<PrizeResponse> list = new ArrayList<>();
        for (Prize prize : prizeList) {
            PrizeResponse prizeResponse = new PrizeResponse();
            BeanUtils.copyProperties(prize,prizeResponse);
            list.add(prizeResponse);
        }
        selectPrizeResponse.setPrizeResponseList(list);
        selectPrizeResponse.setTotal(prizeDao.countAllPrize());
        return selectPrizeResponse;
    }
}
