package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字典表
 */
@Data
@TableName(value = "sys_dict_item")
public class DictItemDO {

    @ApiModelProperty("字典类型编码")
    private String typeCode;

    @ApiModelProperty("字典项编码")
    private String itemCode;

    @ApiModelProperty("字典类型名称")
    private String typeName;

    @ApiModelProperty("字典项值")
    private String itemName;

    @ApiModelProperty("排序字段")
    private Integer orderNum;
}