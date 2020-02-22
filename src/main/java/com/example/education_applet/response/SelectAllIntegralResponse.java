package com.example.education_applet.response;

/**
 * 查找所有积分记录的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectAllIntegralResponse {

    private List<AllIntegralResponse> allIntegralResponseList;

    private Integer total;
}
