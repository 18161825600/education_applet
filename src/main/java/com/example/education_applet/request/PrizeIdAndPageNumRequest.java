package com.example.education_applet.request;

/**
 * 奖品id和页数的请求
 */

import lombok.Data;

@Data
public class PrizeIdAndPageNumRequest {

    private Long prizeId;

    private Integer pageNum;
}
