package com.example.education_applet.response.prizeResponse;

/**
 * 查询景点的返回值
 */

import com.example.education_applet.response.prizeResponse.PrizeResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectPrizeResponse implements Serializable {

    private static final long serialVersionUID = 4121956616800553878L;
    private List<PrizeResponse> prizeResponseList;

    private Integer total;
}
