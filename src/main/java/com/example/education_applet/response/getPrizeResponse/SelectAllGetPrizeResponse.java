package com.example.education_applet.response.getPrizeResponse;

import com.example.education_applet.response.prizeResponse.GetAllPrizeResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查找所有获得奖品记录
 */

@Data
public class SelectAllGetPrizeResponse implements Serializable {

    private static final long serialVersionUID = 419191649121401857L;
    private List<GetAllPrizeResponse> getAllPrizeResponseList;

    private Integer total;
}
