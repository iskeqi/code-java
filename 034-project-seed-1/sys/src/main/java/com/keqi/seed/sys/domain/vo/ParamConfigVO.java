package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ParamConfigVO {

    @ApiModelProperty(value = "参数配置ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "名称", example = "首页LOGO")
    private String paramName;

    @ApiModelProperty(value = "键名", example = "main-logo")
    private String paramKey;

    @ApiModelProperty(value = "键值", example = "/adfa/dfad/a.png")
    private String paramValue;

    @ApiModelProperty(value = "类型（typeCode：configType）", example = "configType_xtnz")
    private String paramType;

    @ApiModelProperty(value = "类型（typeCode：configType）", example = "系统内置")
    private String paramTypeName;

    @ApiModelProperty(value = "创建时间", example = "2020-12-12 12:12:12")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间", example = "2020-12-12 12:12:12")
    private LocalDateTime updateTime;

}