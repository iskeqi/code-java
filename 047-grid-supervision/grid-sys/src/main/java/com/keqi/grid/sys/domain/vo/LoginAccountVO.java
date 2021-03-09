package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginAccountVO {

    private Long id;

    private String token;

    private Long accountId;

    private LocalDateTime createTime;

}