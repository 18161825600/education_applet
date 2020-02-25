package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.*;
import com.example.education_applet.request.getPrizeRequest.AddGetPrizeRequest;
import com.example.education_applet.request.prizeRequest.PrizeIdAndPageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.response.prizeResponse.GetPrizeByIdResponse;
import com.example.education_applet.response.getPrizeResponse.SelectAllGetPrizeResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByPrizeIdResponse;
import com.example.education_applet.response.getPrizeResponse.SelectGetPrizeByUserIdResponse;
import com.example.education_applet.service.GetPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPrizeController {

    @Autowired
    private GetPrizeService getPrizeService;

    @PostMapping(value = "insert/getPrize")
    public EducationJsonResult<Integer> insertGetPrize(@RequestBody AddGetPrizeRequest addGetPrizeRequest){
        Integer integer = getPrizeService.insertGetPrize(addGetPrizeRequest);
        if(integer==1) {
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @DeleteMapping(value = "delete/getPrize")
    public EducationJsonResult<Integer> deleteGetPrize(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(getPrizeService.deleteGetPrize(idsRequest));
    }

    @PostMapping(value = "select/getPrize/by/id")
    public EducationJsonResult<GetPrizeByIdResponse> selectGetPrizeById(@RequestBody IdRequest idRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeById(idRequest));
    }

    @PostMapping(value = "select/getPrize/by/userId")
    public EducationJsonResult<SelectGetPrizeByUserIdResponse> selectGetPrizeByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/getPrize/by/prizeId")
    public EducationJsonResult<SelectGetPrizeByPrizeIdResponse> selectGetPrizeByPrizeId(@RequestBody PrizeIdAndPageNumRequest prizeIdAndPageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeByPrizeId(prizeIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/getPrize")
    public EducationJsonResult<SelectAllGetPrizeResponse> selectAllGetPrize(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectAllGetPrize(pageNumRequest));
    }
}
