package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuParam {

	@ApiModelProperty(value = "菜单权限ID", example = "", required = true)
	private Long id;

	@ApiModelProperty(value = "名称", example = "", required = true)
	private String name;

	@ApiModelProperty(value = "请求URL地址", example = "", required = true)
	private String url;

	@ApiModelProperty(value = "ICON图标", example = "", required = true)
	private String icon;

	@ApiModelProperty(value = "菜单类型（C目录 M菜单 B按钮）", example = "", required = true)
	private String type;

	@ApiModelProperty(value = "权限标识", example = "", required = true)
	private String permiss;

	@ApiModelProperty(value = "排序字段", example = "", required = true)
	private Integer orderNum;

	@ApiModelProperty(value = "父级ID", example = "", required = true)
	private Long parentId;

	@ApiModelProperty(value = "创建时间", example = "", required = true)
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间", example = "", required = true)
	private LocalDateTime updateTime;

}