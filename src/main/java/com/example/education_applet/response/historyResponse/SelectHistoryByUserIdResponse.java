package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectHistoryByUserIdResponse implements Serializable {
    private static final long serialVersionUID = 2248513780504547823L;

    private List<HistoryByUserIdResponse> historyByUserIdResponseList;

    private Integer total;
}
