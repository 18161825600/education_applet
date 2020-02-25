package com.example.education_applet.request.prizeRequest;

/**
 * 修改奖品的请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePrizeRequest implements Serializable {

    private static final long serialVersionUID = 1917983902103786498L;
    private Long id;

    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
