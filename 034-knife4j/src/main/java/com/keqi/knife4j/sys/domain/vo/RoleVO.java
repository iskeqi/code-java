package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO {

	@ApiModelProperty(value = "角色ID", example = "", required = true)
	private Long id;

	@ApiModelProperty(value = "角色名称", example = "", required = true)
	private String name;

	@ApiModelProperty(value = "创建时间", example = "", required = true)
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间", example = "", required = true)
	private LocalDateTime updateTime;

}