package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HistoryByVideoIdResponse implements Serializable {
    private static final long serialVersionUID = -2653949118460284998L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String createTime;
}
