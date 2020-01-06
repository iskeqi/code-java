package com.keqi.springbootmybatisplusmysql.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CodeGenVO {

	private Long id;

	private String username;

	private Integer age;

	private Float weight;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

}
