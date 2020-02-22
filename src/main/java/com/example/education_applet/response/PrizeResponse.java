package com.example.education_applet.response;

/**
 * 奖品的返回值
 */

import lombok.Data;

@Data
public class PrizeResponse {

    private Long id;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
