package com.example.education_applet.request.userRequest;

/**
 * 用户id和页数请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UserIdAndPageNumRequest implements Serializable {

    private static final long serialVersionUID = -440683620473003089L;
    private Long userId;

    private Integer pageNum = 1;
}
