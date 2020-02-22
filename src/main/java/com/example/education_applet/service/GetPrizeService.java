package com.example.education_applet.service;

import com.example.education_applet.pojo.GetPrize;
import com.example.education_applet.request.*;
import com.example.education_applet.response.GetPrizeByIdResponse;

import java.util.List;

public interface GetPrizeService {

    Integer insertGetPrize(AddGetPrizeRequest addGetPrizeRequest);

    Integer deleteGetPrize(IdsRequest idsRequest);

    GetPrizeByIdResponse selectGetPrizeById(IdRequest idRequest);

    List<GetPrize> selectGetPrizeByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    List<GetPrize> selectGetPrizeByPrizeId(PrizeIdAndPageNumRequest prizeIdAndPageNumRequest);

    List<GetPrize> selectAllGetPrize(PageNumRequest pageNumRequest);
}
