package com.example.education_applet.request;

/**
 * 添加奖品请求
 */

import lombok.Data;

@Data
public class AddPrizeRequest {

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
