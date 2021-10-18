package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class MenuDO extends BaseDO {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("请求URL地址")
    private String url;

    @ApiModelProperty("ICON图标")
    private String icon;

    @ApiModelProperty("菜单类型 [C 目录，M 菜单，B 按钮]")
    private String type;

    @ApiModelProperty("权限标识")
    private String permiss;

    @ApiModelProperty("父级ID")
    private Long parentId;

    @ApiModelProperty("排序字段")
    private Integer orderNum;
}