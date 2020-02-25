package com.example.education_applet.service;

import com.example.education_applet.request.*;
import com.example.education_applet.request.videoRequest.*;
import com.example.education_applet.response.videoResponse.SelectVideoByIdResponse;
import com.example.education_applet.response.videoResponse.SelectVideoResponse;

public interface VideoService {

    Integer insertVideo(AddVideoRequest addVideoRequest);

    Integer deleteVideo(IdsRequest idsRequest);

    Integer updateVideoVip(UpdateVideoVipRequest updateVideoVipRequest);

    <T>T selectVideoById(VideoIdAndUserIdRequest videoIdAndUserIdRequest);

    SelectVideoResponse selectVideoByName(SelectVideoByNameRequest selectVideoByNameRequest);

    SelectVideoResponse selectVideoByType(SelectVideoByTypeRequest selectVideoByTypeRequest);

    SelectVideoResponse selectVideoByVip(SelectVideoByVipRequest selectVideoByVipRequest);

    SelectVideoResponse selectAllVideo(PageNumRequest pageNumRequest);
}
