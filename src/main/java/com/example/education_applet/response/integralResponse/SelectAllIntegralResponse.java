package com.example.education_applet.response.integralResponse;

/**
 * 查找所有积分记录的返回值
 */

import com.example.education_applet.response.integralResponse.AllIntegralResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectAllIntegralResponse implements Serializable {

    private static final long serialVersionUID = 2415619190511520481L;
    private List<AllIntegralResponse> allIntegralResponseList;

    private Integer total;
}
