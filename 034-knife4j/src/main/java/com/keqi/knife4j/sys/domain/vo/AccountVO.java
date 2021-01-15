package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountVO {

	@ApiModelProperty(value = "用户ID", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "用户名", example = "jack")
	private String account;

	@ApiModelProperty(value = "姓名", example = "杰克")
	private String nickName;
}