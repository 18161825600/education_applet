package com.example.education_applet.response.getPrizeResponse;

import com.example.education_applet.response.prizeResponse.GetPrizeByUserIdResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通过用户id查找所有获得奖品返回值
 */
@Data
public class SelectGetPrizeByUserIdResponse implements Serializable {

    private static final long serialVersionUID = 9215128950245616726L;
    private List<GetPrizeByUserIdResponse> getPrizeByUserIdResponseList;

    private Integer total;
}
