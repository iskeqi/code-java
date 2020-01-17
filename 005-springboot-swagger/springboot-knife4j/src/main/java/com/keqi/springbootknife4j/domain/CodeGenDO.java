package com.keqi.springbootknife4j.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName(value = "t_code_gen")
public class CodeGenDO {

	private String username;

	private Integer age;

	private Float weight;

	// 设置主键策略为数据库ID自增
	@TableId(type = IdType.AUTO)
	private Long id;

	// insert时会填充此字段
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	// insert和update时都会填充字段
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	private String createBy;

	private String updateBy;

}
