package com.example.education_applet.response;

import lombok.Data;

import java.util.Date;


/**
 * 通过id查找兑换奖品记录的返回值
 */

@Data
public class GetPrizeByIdResponse {

    private String nickName;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;

    private Integer prizeTotalIntegral;

    private Date createTime;
}
