package com.example.education_applet.response.userResponse;

/**
 * 查找所有用户的返回值
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectAllUserResponse implements Serializable {

    private static final long serialVersionUID = 2273038419457997558L;
    private List<SelectUserResponse> selectUserResponseList;

    private Integer total;
}
