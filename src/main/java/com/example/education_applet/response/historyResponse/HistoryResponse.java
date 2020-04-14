package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HistoryResponse implements Serializable {
    private static final long serialVersionUID = -5531651369613558808L;

    private String nickName;

    private String headUrl;

    private Short isVip;

    private String videoName;

    private String videoPicture;

    private String createTime;
}
