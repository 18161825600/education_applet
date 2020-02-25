package com.example.education_applet.response.getPrizeResponse;

import com.example.education_applet.response.prizeResponse.GetPrizeByPrizeIdResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通过奖品id查找所有获得奖品记录
 */

@Data
public class SelectGetPrizeByPrizeIdResponse implements Serializable {

    private static final long serialVersionUID = 8510574953482844548L;
    private List<GetPrizeByPrizeIdResponse> getPrizeByPrizeIdResponseList;

    private Integer total;
}
