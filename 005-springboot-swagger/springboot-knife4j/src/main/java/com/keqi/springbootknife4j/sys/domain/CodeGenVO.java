package com.keqi.springbootknife4j.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenVO {

	@ApiModelProperty(value = "主键", required = true, example = "201")
	private Long id;

	@ApiModelProperty(value = "用户名", required = true, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄", required = true, example = "29")
	private Integer age;

	@ApiModelProperty(value = "体重", required = true, example = "67.43")
	private Float weight;

	@ApiModelProperty(value = "创建时间", required = true, example = "2019-12-12 12:32:34")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

}
