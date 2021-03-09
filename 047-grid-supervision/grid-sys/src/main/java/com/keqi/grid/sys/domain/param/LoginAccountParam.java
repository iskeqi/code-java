package com.keqi.grid.sys.domain.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginAccountParam {

    private Long id;

    private String token;

    private Long accountId;

}