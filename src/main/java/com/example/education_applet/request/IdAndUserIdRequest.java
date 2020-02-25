package com.example.education_applet.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdAndUserIdRequest implements Serializable {
    private static final long serialVersionUID = -7934383191745609567L;

    private Long id;

    private Long userId;
}
