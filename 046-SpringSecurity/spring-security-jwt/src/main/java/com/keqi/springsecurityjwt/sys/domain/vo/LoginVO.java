package com.keqi.springsecurityjwt.sys.domain.vo;

import lombok.Data;

@Data
public class LoginVO {

    private String token;

    public LoginVO() {
    }

    public LoginVO(String token) {
        this.token = token;
    }
}
