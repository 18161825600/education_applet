package com.example.education_applet.request;

import lombok.Data;

/**
 * 添加兑换奖品的记录请求
 */

@Data
public class AddGetPrizeRequest {

    private Long userId;

    private Long prizeId;

    private Integer prizeNum;
}
