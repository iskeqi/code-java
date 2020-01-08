package com.keqi.springbootmybatisplusmysql.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName(value = "t_code_gen_db")
public class CodeGenDbDO {

	@TableId(type = IdType.AUTO)
	private Long id;

	private String username;

	private Integer age;

	private Float weight;


	// 法二：表中的这两个字段设置默认值为当前时间，且updateTime设置为自动更新，然后设置mp在插入和修改时忽略这个字段

		// insert: INSERT INTO t_code_gen_db ( username, age, weight ) VALUES ( 'fdafa', 1223, 23.32 );
		// update: UPDATE t_code_gen_db SET username='fdafa', age=12234312, weight=23.32 WHERE id=5;

	// insert/update 都直接忽略这个字段(不加入 SQL)
	@TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
	private LocalDateTime createTime;

	// insert/update 都直接忽略这个字段(不加入 SQL)
	@TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
	private LocalDateTime updateTime;

	private String createBy;

	private String updateBy;

}
