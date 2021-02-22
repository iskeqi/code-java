package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleVO {

	@ApiModelProperty(value = "角色ID", example = "2")
	private Long id;

	@ApiModelProperty(value = "角色名称", example = "管理员")
	private String name;

	@ApiModelProperty(value = "权限标识", example = "admin")
	private String permiss;
}