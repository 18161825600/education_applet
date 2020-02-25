package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.historyResponse.AllHistoryResponse;
import com.example.education_applet.response.historyResponse.SelectHistoryByUserIdResponse;
import com.example.education_applet.response.historyResponse.SelectHistoryByVideoIdResponse;
import com.example.education_applet.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping(value = "delete/history")
    public EducationJsonResult<Integer> deleteHistory(@RequestBody IdsRequest idsRequest){
        Integer integer = historyService.deleteHistory(idsRequest);
        if(integer==0){
            return EducationJsonResult.errorMsg("false");
        }
        return EducationJsonResult.ok(integer);
    }

    @PostMapping(value = "select/history/by/userId")
    public EducationJsonResult<SelectHistoryByUserIdResponse> selectHistoryByUserId(@RequestBody UserIdAndPageNumRequest userIdAndPageNumRequest){
        return EducationJsonResult.ok(historyService.selectHistoryByUserId(userIdAndPageNumRequest));
    }

    @PostMapping(value = "select/history/by/videoId")
    public EducationJsonResult<SelectHistoryByVideoIdResponse> selectHistoryByVideoId(@RequestBody VideoIdAndPageNumRequest videoIdAndPageNumRequest){
        return EducationJsonResult.ok(historyService.selectHistoryByVideoId(videoIdAndPageNumRequest));
    }

    @PostMapping(value = "select/all/history")
    public EducationJsonResult<AllHistoryResponse> selectAllHistory(@RequestBody PageNumRequest pageNumRequest){
        return EducationJsonResult.ok(historyService.selectAllHistory(pageNumRequest));
    }
}
