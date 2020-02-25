package com.example.education_applet.response.prizeResponse;

/**
 * 奖品的返回值
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class PrizeResponse implements Serializable {

    private static final long serialVersionUID = 7655346137859238181L;
    private Long id;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
