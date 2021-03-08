package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoleVO {

    private Long id;

    private String name;

    private String permiss;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}