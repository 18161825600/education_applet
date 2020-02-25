package com.example.education_applet.response.prizeResponse;

/**
 * 通过id查找奖品返回值
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class PrizeByIdResponse implements Serializable {

    private static final long serialVersionUID = -7382270870865603742L;
    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
