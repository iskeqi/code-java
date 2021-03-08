package com.keqi.grid.sys.domain.vo;

import lombok.Data;


@Data
public class MenuVO {

    private Long id;

    private String name;

    private String url;

    private String icon;

    private String type;

    private String permiss;

    private Long parentId;

    private Integer orderNum;

}