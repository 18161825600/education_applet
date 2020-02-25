package com.example.education_applet.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = -7398896694254749587L;

    private Long id;

    private Integer pageNum = 1;
}
