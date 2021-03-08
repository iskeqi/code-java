package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UploadFileVO {

    private Long id;

    private String name;

    private String path;

    private String type;

    private Long size;

    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}