package com.keqi.grid.sys.domain.param;

import lombok.Data;


@Data
public class MenuParam {

    private Long id;

    private String name;

    private String url;

    private String icon;

    private String type;

    private String permiss;

    private Long parentId;

    private Integer orderNum;

}