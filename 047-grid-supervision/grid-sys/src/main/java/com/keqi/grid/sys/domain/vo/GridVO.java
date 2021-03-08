package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GridVO {

    private Long id;

    private String name;

    private BigDecimal area;

    private Integer orderNum;

    private Long parentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}