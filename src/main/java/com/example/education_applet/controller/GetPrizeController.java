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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户兑换奖品")
@RestController
public class GetPrizeController {

    @Autowired
    private GetPrizeService getPrizeService;

    @ApiOperation(value = "通过奖品id和用户id添加获得奖品记录(Z&U)")
    @PostMapping(value = "insert/getPrize")
    public EducationJsonResult<Integer> insertGetPrize(@RequestBody AddGetPrizeRequest addGetPrizeRequest){
        Integer integer = getPrizeService.insertGetPrize(addGetPrizeRequest);
        if(integer==1) {
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过奖品的主键id批量删除获得奖品记录(Z&U)")
    @DeleteMapping(value = "delete/getPrize")
    public EducationJsonResult<Integer> deleteGetPrize(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok(getPrizeService.deleteGetPrize(idsRequest));
    }

    @ApiOperation(value = "通过奖品记录id查看获得获得奖品记录(Z&U)")
    @PostMapping(value = "select/getPrize/by/id")
    public EducationJsonResult<GetPrizeByIdResponse> selectGetPrizeById(@RequestBody IdRequest idRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeById(idRequest));
    }

    @ApiOperation(value = "通过用户id查看该用户获得奖品的记录(Z&U)")
    @PostMapping(value = "select/getPrize/by/userId")
    public EducationJsonResult<SelectGetPrizeByUserIdResponse> selectGetPrizeByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeByUserId(userIdAndPageNumRequest));
    }

    @ApiOperation(value = "通过奖品id查看该奖品被哪些用户兑换过(Admin)")
    @PostMapping(value = "select/getPrize/by/prizeId")
    public EducationJsonResult<SelectGetPrizeByPrizeIdResponse> selectGetPrizeByPrizeId(@RequestBody PrizeIdAndPageNumRequest prizeIdAndPageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectGetPrizeByPrizeId(prizeIdAndPageNumRequest));
    }

    @ApiOperation(value = "查看数据库中所有的兑换记录(Admin)")
    @PostMapping(value = "select/all/getPrize")
    public EducationJsonResult<SelectAllGetPrizeResponse> selectAllGetPrize(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(getPrizeService.selectAllGetPrize(pageNumRequest));
    }
}
