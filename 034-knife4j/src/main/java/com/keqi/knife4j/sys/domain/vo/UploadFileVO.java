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

    @ApiModelProperty(value = "文件名称", example = "字典数据表")
    private String name;

    public UploadFileVO() {
    }

    public UploadFileVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}