package com.example.education_applet.response;

/**
 * 查找所有用户的返回值
 */

import lombok.Data;

import java.util.List;

@Data
public class SelectAllUserResponse {

    private List<SelectUserResponse> selectUserResponseList;

    private Integer total;
}
