package com.example.education_applet.request;

/**
 * ids请求
 */

import lombok.Data;

import java.util.List;

@Data
public class IdsRequest {

    private List<Long> ids;
}
