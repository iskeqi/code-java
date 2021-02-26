package com.keqi.springsecurityjwt.sys.domain.param;

import lombok.Data;

@Data
public class LoginParam {

    private String username;

    private String password;

    private String devType;
}
