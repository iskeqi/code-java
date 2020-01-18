package com.keqi.springbootknife4j.dev.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CodeGenVO {

	@ApiModelProperty(value = "主键", dataType = "Long", required = true,
			position = 1, example = "201")
	private Long id;

	@ApiModelProperty(value = "用户名", dataType = "String", required = true,
			position = 2, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄", dataType = "Integer", required = true,
			position = 3, example = "29")
	private Integer age;

	@ApiModelProperty(value = "体重", dataType = "Float", required = true,
			position = 4, example = "67.43")
	private Float weight;

	@ApiModelProperty(value = "创建时间", dataType = "LocalDateTime", required = true,
			position = 5, example = "2019-12-12 12:32:34")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

}
