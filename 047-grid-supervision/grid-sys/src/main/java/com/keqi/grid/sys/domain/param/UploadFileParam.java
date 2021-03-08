package com.keqi.grid.sys.domain.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UploadFileParam {

    private Long id;

    private String name;

    private String path;

    private String type;

    private Long size;

    private Integer deleted;

}