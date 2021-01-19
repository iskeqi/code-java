package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class MenuVO {

	@ApiModelProperty(value = "菜单权限ID", example = "1")
	private Long id;

	@ApiModelProperty(value = "名称", example = "系统管理")
	private String name;

	@ApiModelProperty(value = "请求URL地址", example = "/sys/mana")
	private String url;

	@ApiModelProperty(value = "ICON图标", example = "ele-eleme")
	private String icon;

	@ApiModelProperty(value = "菜单类型（C目录 M菜单 B按钮）", example = "C")
	private String type;

	@ApiModelProperty(value = "权限标识", example = "xtgl")
	private String permiss;

	@ApiModelProperty(value = "排序字段", example = "1")
	private Integer orderNum;

	@ApiModelProperty(value = "父级ID", example = "0")
	private Long parentId;

	@ApiModelProperty(value = "菜单列表")
	private List<MenuVO> menuList;
}