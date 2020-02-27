package com.keqi.springbootmpdynamic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName(value = "USER")
public class UserDO {

	// 设置主键策略为数据库ID自增
	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

	private Integer age;
}
