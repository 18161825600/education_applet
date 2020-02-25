package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectHistoryByVideoIdResponse implements Serializable {
    private static final long serialVersionUID = 2249037797399537862L;

    private List<HistoryByVideoIdResponse> historyByVideoIdResponseList;

    private Integer total;
}
