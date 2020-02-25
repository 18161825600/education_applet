package com.example.education_applet.response.prizeResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 通过id查找兑换奖品记录的返回值
 */

@Data
public class GetPrizeByIdResponse implements Serializable {

    private static final long serialVersionUID = 5737254813819402625L;
    private String nickName;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;

    private Integer prizeTotalIntegral;

    private Date createTime;
}
