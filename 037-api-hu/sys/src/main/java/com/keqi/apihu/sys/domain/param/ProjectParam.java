package com.keqi.apihu.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectParam {

    @ApiModelProperty(value = "项目主键", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "项目名称", example = "API-HU项目", required = true)
    private String projectName;

    @ApiModelProperty(value = "项目描述信息")
    private String projectNote;
}