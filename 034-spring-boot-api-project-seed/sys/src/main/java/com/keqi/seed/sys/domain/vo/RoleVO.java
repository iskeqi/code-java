package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RoleVO {

	@ApiModelProperty(value = "角色ID", example = "2", required = true)
	private Long id;

	@ApiModelProperty(value = "角色名称", example = "管理员", required = true)
	private String name;
}