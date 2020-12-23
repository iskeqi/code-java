package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 文件表
    */
@Data
public class UploadFileVO {

    @ApiModelProperty(value = "文件ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "文件名称", example = "85b4f070-d238-4e34-bd40-d72885a42f6fSnipaste_2020-12-23_11-23-11.png")
    private String name;

    @ApiModelProperty(value = "文件存储路径（相对路径）", example = "/2020-12-23/image/png/")
    private String path;

    public UploadFileVO() {
    }

    public UploadFileVO(Long id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }
}