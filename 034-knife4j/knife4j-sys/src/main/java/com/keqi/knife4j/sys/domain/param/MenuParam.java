package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MenuParam {

	@ApiModelProperty(value = "菜单权限ID", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "名称", example = "系统管理", required = true)
	private String name;

	@ApiModelProperty(value = "请求URL地址", example = "/sys/mana", required = true)
	private String url;

	@ApiModelProperty(value = "ICON图标", example = "ele-eleme", required = true)
	private String icon;

	@ApiModelProperty(value = "菜单类型（C目录 M菜单 B按钮）", example = "C", required = true)
	private String type;

	@ApiModelProperty(value = "权限标识", example = "xtgl", required = true)
	private String permiss;

	@ApiModelProperty(value = "排序字段", example = "1", required = true)
	private Integer orderNum;

	@ApiModelProperty(value = "父级ID", example = "0", required = true)
	private Long parentId;
}