package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 字典表
 */
@Data
@Accessors(chain = true)
@TableName(value = "sys_dict_item")
public class DictItemDO {

    @NotNull
    @ApiModelProperty("字典类型编码")
    private String typeCode;

    @NotNull
    @ApiModelProperty("字典项编码")
    private String itemCode;

    @NotNull
    @ApiModelProperty("字典类型名称")
    private String typeName;

    @NotNull
    @ApiModelProperty("字典项值")
    private String itemName;

    @NotNull
    @ApiModelProperty("排序字段")
    private Integer orderNum;
}