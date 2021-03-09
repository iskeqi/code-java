package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GridVO {

    private Long id;

    private String name;

    private BigDecimal area;

    private Integer orderNum;

    private Long parentId;

    private List<GridVO> subList;

    public GridVO() {
    }

    public GridVO(Long id, String name, BigDecimal area, Integer orderNum, Long parentId) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.orderNum = orderNum;
        this.parentId = parentId;
    }
}