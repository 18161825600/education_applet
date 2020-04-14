package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HistoryByUserIdResponse implements Serializable {

    private static final long serialVersionUID = 641069044296945291L;

    private String videoName;

    private String videoPicture;

    private String createTime;
}
