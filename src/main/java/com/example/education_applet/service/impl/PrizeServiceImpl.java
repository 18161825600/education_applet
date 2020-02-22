package com.example.education_applet.service.impl;

import com.example.education_applet.dao.PrizeDao;
import com.example.education_applet.pojo.Prize;
import com.example.education_applet.request.*;
import com.example.education_applet.response.PrizeByIdResponse;
import com.example.education_applet.response.PrizeResponse;
import com.example.education_applet.response.SelectPrizeResponse;
import com.example.education_applet.service.PrizeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
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
