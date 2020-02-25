package com.example.education_applet.request.prizeRequest;

/**
 * 奖品id和页数的请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class PrizeIdAndPageNumRequest implements Serializable {

    private static final long serialVersionUID = -7869529075908300734L;
    private Long prizeId;

    private Integer pageNum = 1;
}
