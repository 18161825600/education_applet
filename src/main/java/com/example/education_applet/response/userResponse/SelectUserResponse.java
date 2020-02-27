package com.example.education_applet.response.userResponse;

/**
 * 查找用户的返回值
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelectUserResponse implements Serializable {

    private static final long serialVersionUID = -2032215135197424282L;

    private Long id;

    private String openId;

    private String nickName;

    private String phoneNum;

    private String headUrl;

    private Integer integral;

    private Short isVip;

    private Date vipDueTime;

    private Short userPower;

    private Date createTime;
}
