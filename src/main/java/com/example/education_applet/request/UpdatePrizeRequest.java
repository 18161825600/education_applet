package com.example.education_applet.request;

/**
 * 修改奖品的请求
 */

import lombok.Data;

@Data
public class UpdatePrizeRequest {

    private Long id;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
