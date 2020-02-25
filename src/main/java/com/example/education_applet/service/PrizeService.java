package com.example.education_applet.service;

import com.example.education_applet.request.*;
import com.example.education_applet.request.prizeRequest.AddPrizeRequest;
import com.example.education_applet.request.prizeRequest.UpdatePrizeRequest;
import com.example.education_applet.response.prizeResponse.PrizeByIdResponse;
import com.example.education_applet.response.prizeResponse.SelectPrizeResponse;

public interface PrizeService {

    Integer insertPrize(AddPrizeRequest addPrizeRequest);

    Integer deletePrize(IdsRequest idsRequest);

    Integer updatePrize(UpdatePrizeRequest updatePrizeRequest);

    PrizeByIdResponse selectPrizeById(IdRequest idRequest);

    SelectPrizeResponse selectAllPrize(PageNumRequest pageNumRequest);
}
