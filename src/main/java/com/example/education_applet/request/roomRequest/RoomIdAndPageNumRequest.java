package com.example.education_applet.request.roomRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomIdAndPageNumRequest implements Serializable {
    private static final long serialVersionUID = -1296673434697712758L;

    private Long roomId;

    private Integer pageNum = 1;
}
