package com.example.education_applet.request.userRequest;

/**
 * 修改用户基础信息的请求
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserBaseInfoRequest implements Serializable {

    private static final long serialVersionUID = 645803194638786885L;
    private Long id;

    private String nickName;

    private String phoneNum;

    private String headUrl;
}
