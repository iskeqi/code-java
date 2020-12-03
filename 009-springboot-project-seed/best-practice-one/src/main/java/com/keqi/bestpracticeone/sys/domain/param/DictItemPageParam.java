package com.keqi.bestpracticeone.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictItemPageParam {

    @ApiModelProperty(value = "字典类型编码")
    private String typeCode;

    @ApiModelProperty(value = "字典类型名称")
    private String typeName;

    @ApiModelProperty(value = "字典项编码")
    private String itemCode;

    @ApiModelProperty(value = "字典项值")
    private String itemName;

    @ApiModelProperty(value = "前页数", example = "1", required = true)
    protected int current = 1;

    @ApiModelProperty(value = "每页大小", example = "10", required = true)
    protected int size = 10;
}
