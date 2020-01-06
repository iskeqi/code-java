package com.keqi.springbootmybatisplusmysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_code_gen")
public class CodeGenDO {

	@TableId(type = IdType.AUTO)
	private Long id;

	private String username;

	private Integer age;

	private Float weight;


	// 实际编程中，这4个属性没有必要出现在实体类中
	// 后两个不要，前面两个日期时间改为自动更改的那种就行
	// 但是如果需要取出这两个时间的时候，又怎么办呢？纠结。。

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private String createBy;

	private String updateBy;

}
