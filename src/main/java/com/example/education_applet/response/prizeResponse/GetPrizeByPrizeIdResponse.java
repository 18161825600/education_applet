package com.example.education_applet.response.prizeResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通过奖品id查找获得奖品记录
 */
@Data
public class GetPrizeByPrizeIdResponse implements Serializable {

    private static final long serialVersionUID = -5411121232034764265L;
    private String nickName;

    private Integer prizeNum;

    private Integer prizeTotalIntegral;

    private String createTime;
}
