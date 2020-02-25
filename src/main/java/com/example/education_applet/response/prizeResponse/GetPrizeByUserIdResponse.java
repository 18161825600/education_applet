package com.example.education_applet.response.prizeResponse;

import lombok.Data;

/**
 * 通过用户id获得奖品返回值
 */
import java.io.Serializable;
import java.util.Date;

@Data
public class GetPrizeByUserIdResponse implements Serializable {

    private static final long serialVersionUID = -5427527555306737244L;
    private String prizeName;

    private Integer prizeNum;

    private Integer prizeTotalIntegral;

    private Date createTime;
}
