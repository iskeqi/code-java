package com.keqi.grid.sys.domain.param;

import lombok.Data;


@Data
public class DictItemParam {

    private Long id;

    private String typeCode;

    private String typeName;

    private String itemCode;

    private String itemName;

    private Integer orderNum;

}