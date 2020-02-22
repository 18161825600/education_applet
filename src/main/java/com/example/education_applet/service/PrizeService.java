package com.example.education_applet.service;

import com.example.education_applet.pojo.Prize;
import com.example.education_applet.request.*;
import com.example.education_applet.response.PrizeByIdResponse;
import com.example.education_applet.response.SelectPrizeResponse;

import java.util.List;

public interface PrizeService {

    Integer insertPrize(AddPrizeRequest addPrizeRequest);

    Integer deletePrize(IdsRequest idsRequest);

    Integer updatePrize(UpdatePrizeRequest updatePrizeRequest);

    PrizeByIdResponse selectPrizeById(IdRequest idRequest);

    SelectPrizeResponse selectAllPrize(PageNumRequest pageNumRequest);
}
