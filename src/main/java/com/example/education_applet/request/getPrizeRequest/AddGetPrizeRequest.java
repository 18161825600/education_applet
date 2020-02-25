package com.example.education_applet.request.getPrizeRequest;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加兑换奖品的记录请求
 */

@Data
public class AddGetPrizeRequest implements Serializable {

    private static final long serialVersionUID = 2260003754361252121L;
    private Long userId;

    private Long prizeId;

}
