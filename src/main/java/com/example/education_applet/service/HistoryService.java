package com.example.education_applet.service;

import com.example.education_applet.request.IdAndPageNumRequest;
import com.example.education_applet.request.IdsRequest;
import com.example.education_applet.request.PageNumRequest;
import com.example.education_applet.request.userRequest.UserIdAndPageNumRequest;
import com.example.education_applet.request.videoRequest.VideoIdAndPageNumRequest;
import com.example.education_applet.response.historyResponse.AllHistoryResponse;
import com.example.education_applet.response.historyResponse.SelectHistoryByUserIdResponse;
import com.example.education_applet.response.historyResponse.SelectHistoryByVideoIdResponse;

public interface HistoryService {

    Integer deleteHistory(IdsRequest idsRequest);

    SelectHistoryByUserIdResponse selectHistoryByUserId(UserIdAndPageNumRequest userIdAndPageNumRequest);

    SelectHistoryByVideoIdResponse selectHistoryByVideoId(VideoIdAndPageNumRequest videoIdAndPageNumRequest);

    AllHistoryResponse selectAllHistory(PageNumRequest pageNumRequest);
}
