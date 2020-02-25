package com.example.education_applet.request;

/**
 * ids请求
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IdsRequest implements Serializable {

    private static final long serialVersionUID = 4327873039502417924L;
    private List<Long> ids;
}
