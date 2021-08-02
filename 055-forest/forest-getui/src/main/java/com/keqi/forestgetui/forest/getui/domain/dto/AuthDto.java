package com.keqi.forestgetui.forest.getui.domain.dto;

import lombok.Data;

@Data
public class AuthDto {

    /**
     * token过期时间，ms时间戳
     */
    private String expire_time;

    /**
     * 接口调用凭据
     */
    private String token;
}
