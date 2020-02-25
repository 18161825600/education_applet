package com.example.education_applet.service;

import com.example.education_applet.request.*;
import com.example.education_applet.request.getPrizeRequest.AddGetPrizeRequest;
import com.example.education_applet.request.prizeRequest.PrizeIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.prizeResponse.GetPrizeByIdResponse;
import com.example.education_applet.response.getPrizeResponse.SelectAllGetPrizeResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByPrizeIdResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByUserIdResponse;

public interface GetPrizeService {

    Integer insertGetPrize(AddGetPrizeRequest addGetPrizeRequest);

    Integer deleteGetPrize(IdsRequest idsRequest);

    GetPrizeByIdResponse selectGetPrizeById(IdRequest idRequest);

    SelectGetPrizeByUserIdResponse selectGetPrizeByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectGetPrizeByPrizeIdResponse selectGetPrizeByPrizeId(PrizeIdAndPageNumRequest prizeIdAndPageNumRequest);

    SelectAllGetPrizeResponse selectAllGetPrize(PageNumRequest pageNumRequest);
}
