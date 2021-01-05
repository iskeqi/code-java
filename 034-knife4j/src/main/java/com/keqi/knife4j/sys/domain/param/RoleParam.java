package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleParam {

	@ApiModelProperty(value = "角色ID", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "角色名称", example = "管理员", required = true)
	private String name;
}