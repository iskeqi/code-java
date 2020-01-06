package com.keqi.springbootmybatisplusmysql.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CodeGenVO {

	@NotNull
	private Long id;

	private String username;

	private Integer age;

	private Float weight;

	private LocalDateTime createTime;

}
