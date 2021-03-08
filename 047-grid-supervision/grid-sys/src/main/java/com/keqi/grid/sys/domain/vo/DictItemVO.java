package com.keqi.grid.sys.domain.vo;

import lombok.Data;


@Data
public class DictItemVO {

    private Long id;

    private String typeCode;

    private String typeName;

    private String itemCode;

    private String itemName;

    private Integer orderNum;

}