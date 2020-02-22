package com.example.education_applet.response;

/**
 * 查询景点的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectPrizeResponse {

    private List<PrizeResponse> prizeResponseList;

    private Integer total;
}
