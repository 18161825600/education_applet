package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.*;
import com.example.education_applet.request.prizeRequest.AddPrizeRequest;
import com.example.education_applet.request.prizeRequest.UpdatePrizeRequest;
import com.example.education_applet.response.prizeResponse.PrizeByIdResponse;
import com.example.education_applet.response.prizeResponse.SelectPrizeResponse;
import com.example.education_applet.service.PrizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "奖品")
@RestController
public class PrizeController {

    @Autowired
    private PrizeService prizeService;

    @ApiOperation(value = "添加奖品(Admin)")
    @PostMapping(value = "insert/prize")
    public EducationJsonResult<String> insertPrize(@RequestBody AddPrizeRequest addPrizeRequest){
        Integer integer = prizeService.insertPrize(addPrizeRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过奖品的主键id批量删除奖品(Admin)")
    @PostMapping(value = "delete/prize")
    public EducationJsonResult<String> deletePrize(@RequestBody IdsRequest idsRequest){
        return EducationJsonResult.ok("删除了"+prizeService.deletePrize(idsRequest)+"条数据");
    }

    @ApiOperation(value = "通过奖品的主键id修改奖品(Admin)")
    @PostMapping(value = "update/prize")
    public EducationJsonResult<String> updatePrize(@RequestBody UpdatePrizeRequest updatePrizeRequest){
        Integer integer = prizeService.updatePrize(updatePrizeRequest);
        if(integer==1){
            return EducationJsonResult.ok();
        }else return EducationJsonResult.errorMsg("false");
    }

    @ApiOperation(value = "通过奖品的主键id查看奖品详情")
    @PostMapping(value = "select/prize/by/id")
    public EducationJsonResult<PrizeByIdResponse> selectPrizeById(@RequestBody IdRequest idRequest){
        return EducationJsonResult.ok(prizeService.selectPrizeById(idRequest));
    }

    @ApiOperation(value = "查找数据库中的所有奖品")
    @PostMapping(value = "select/all/prize")
    public EducationJsonResult<SelectPrizeResponse> selectAllPrize(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(prizeService.selectAllPrize(pageNumRequest));
    }
}
