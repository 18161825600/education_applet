package com.example.education_applet.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdResponse implements Serializable {
    private static final long serialVersionUID = 9041956570869404566L;

    private Long id;
}
