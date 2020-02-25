package com.example.education_applet.response.historyResponse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AllHistoryResponse implements Serializable {
    private static final long serialVersionUID = -5771257529602076892L;

    private List<HistoryResponse> historyResponseList;

    private Integer total;
}
