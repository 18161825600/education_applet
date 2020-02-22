package com.example.education_applet.response;

/**
 * 通过id查找奖品返回值
 */

import lombok.Data;

@Data
public class PrizeByIdResponse {

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
