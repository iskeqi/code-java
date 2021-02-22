package com.keqi.seed.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AccountUpdateParam {

	@ApiModelProperty(value = "用户ID", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "姓名", example = "杰克", required = true)
	@Size(min = 2, max = 5, message = "姓名长度必须在2-5个字符之间")
	@NotNull
	private String nickName;

	@ApiModelProperty(value = "岗位", example = "java", required = true)
	private String post;

	@ApiModelProperty(value = "角色ID列表", example = "[1,2,3,4,5,6]")
	private List<Long> roleIdList;
}