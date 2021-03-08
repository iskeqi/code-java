package com.keqi.grid.sys.domain.param;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GridParam {

    private Long id;

    private String name;

    private BigDecimal area;

    private Integer orderNum;

    private Long parentId;

}