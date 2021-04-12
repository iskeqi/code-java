package com.keqi.springbootmvctrain.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Teacher
 *
 * @author keqi
 */
@Data
public class Teacher {

	@ApiModelProperty(value = "日期", example = "2010-12-12")
	private LocalDate birthday;

	@ApiModelProperty(value = "创建时间", example = "2010-12-12 12:12:12")
	// @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "年龄", example = "18")
	private Integer age;
}
