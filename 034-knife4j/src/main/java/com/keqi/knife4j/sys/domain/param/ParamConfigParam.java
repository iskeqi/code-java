package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamConfigParam {

    @ApiModelProperty(value = "参数配置ID", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "名称", example = "首页LOGO")
    private String paramName;

    @ApiModelProperty(value = "键名", example = "main-logo")
    private String paramKey;

    @ApiModelProperty(value = "键值", example = "/adfa/dfad/a.png")
    private String paramValue;

    @ApiModelProperty(value = "类型（typeCode：configType）", example = "configType_xtnz")
    private String paramType;

}