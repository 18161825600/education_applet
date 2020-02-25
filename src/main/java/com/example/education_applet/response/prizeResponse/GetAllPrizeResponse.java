package com.example.education_applet.response.prizeResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有获得奖品记录
 */
@Data
public class GetAllPrizeResponse implements Serializable {

    private static final long serialVersionUID = -356284749034981350L;
    private String nickName;

    private String prizeName;

    private Integer prizeNum;

    private Integer prizeTotalIntegral;

    private Date createTime;
}
