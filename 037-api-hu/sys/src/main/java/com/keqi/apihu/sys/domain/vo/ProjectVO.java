package com.keqi.apihu.sys.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO {

    @ApiModelProperty(value = "项目主键", example = "1")
    private Long id;

    @ApiModelProperty(value = "项目名称", example = "API-HU项目")
    private String projectName;

    @ApiModelProperty(value = "项目描述信息", example = "项目描述信息")
    private String projectNote;

    @ApiModelProperty(value = "创建时间", example = "2020-12-21 17:39:32")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createTime;

}
