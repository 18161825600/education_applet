package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.*;
import com.example.education_applet.response.PrizeByIdResponse;
import com.example.education_applet.response.SelectPrizeResponse;
import com.example.education_applet.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrizeController {

    @Autowired
    private PrizeService prizeService;

    @PostMapping(value = "insert/prize")
    public EducationJsonResult<String> insertPrize(AddPrizeRequest addPrizeRequest){
        Integer integer = prizeService.insertPrize(addPrizeRequest);
        if(integer==1){
            return EducationJsonResult.ok("true");
        }else return EducationJsonResult.errorMsg("false");
    }

    @DeleteMapping(value = "delete/prize")
    public EducationJsonResult<String> deletePrize(IdsRequest idsRequest){
        return EducationJsonResult.ok("删除了"+prizeService.deletePrize(idsRequest)+"条数据");
    }

    @PutMapping(value = "update/prize")
    public EducationJsonResult<String> updatePrize(UpdatePrizeRequest updatePrizeRequest){
        Integer integer = prizeService.updatePrize(updatePrizeRequest);
        if(integer==1){
            return EducationJsonResult.ok("true");
        }else return EducationJsonResult.errorMsg("false");
    }

    @PostMapping(value = "select/prize/by/id")
    public EducationJsonResult<PrizeByIdResponse> selectPrizeById(IdRequest idRequest){
        return EducationJsonResult.ok(prizeService.selectPrizeById(idRequest));
    }

    @PostMapping(value = "select/all/prize")
    public EducationJsonResult<SelectPrizeResponse> selectAllPrize(PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(prizeService.selectAllPrize(pageNumRequest));
    }
}
