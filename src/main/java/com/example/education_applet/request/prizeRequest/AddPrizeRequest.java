package com.example.education_applet.request.prizeRequest;

/**
 * 添加奖品请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class AddPrizeRequest implements Serializable {

    private static final long serialVersionUID = 5944099664944952200L;
    private String prizeName;

    private String prizeContent;

    private Integer prizeIntegral;

    private Integer prizeNum;
}
