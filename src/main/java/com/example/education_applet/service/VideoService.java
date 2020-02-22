package com.example.education_applet.service;

import com.example.education_applet.request.*;
import com.example.education_applet.response.SelectVideoByIdResponse;
import com.example.education_applet.response.SelectVideoResponse;

public interface VideoService {

    Integer insertVideo(AddVideoRequest addVideoRequest);

    Integer deleteVideo(IdsRequest idsRequest);

    Integer updateVideoVip(UpdateVideoVipRequest updateVideoVipRequest);

    SelectVideoByIdResponse selectVideoById(IdRequest idRequest);

    SelectVideoResponse selectVideoByName(SelectVideoByNameRequest selectVideoByNameRequest);

    SelectVideoResponse selectVideoByType(SelectVideoByTypeRequest selectVideoByTypeRequest);

    SelectVideoResponse selectVideoByVip(SelectVideoByVipRequest selectVideoByVipRequest);

    SelectVideoResponse selectAllVideo(PageNumRequest pageNumRequest);
}
