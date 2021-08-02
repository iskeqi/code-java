package com.keqi.forestgetui.forest.getui.domain;

import lombok.Data;

@Data
public class GeTuiResponse<T> {

    private Integer code;

    private String msg;

    private T data;
}
