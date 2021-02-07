package com.keqi.springbootmybatisbase.sys.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}