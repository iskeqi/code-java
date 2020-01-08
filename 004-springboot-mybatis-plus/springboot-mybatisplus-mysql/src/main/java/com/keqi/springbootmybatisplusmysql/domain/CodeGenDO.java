package com.keqi.springbootmybatisplusmysql.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName(value = "t_code_gen")
public class CodeGenDO {

	// 设置主键策略为数据库ID自增
	@TableId(type = IdType.AUTO)
	private Long id;

	private String username;

	private Integer age;

	private Float weight;


	// 实际编程中，这4个属性没有必要出现在实体类中
	// 后两个可以不要，前面两个日期时间改为自动更改的那种就行
	// 但是如果需要取出这两个时间的时候，又怎么办呢？纠结。。

	// 其实Mybatis Plus提供了解决方案哦，只是你一开始不知道罢了(有两种解决办法)
	// 法一：表中的这两个字段不做任何特殊设置，在代码中通过Mybatis Plus的自动填充机制来插入时间(如下)
		// 执行插入时的SQL如下：INSERT INTO t_code_gen ( username, age, weight, create_time, update_time )
		// VALUES ( 'fdafa', 12, 23.32, '2020-01-08T11:51:39.208', '2020-01-08T11:51:39.208' );

		// 执行修改时的SQL如下：
		// UPDATE t_code_gen SET username='fdafa', age=1223, weight=23.32, update_time='2020-01-08T11:54:49.214' WHERE id=4;

		// 总结：到底是应该用这种方法还是第二种，看情况啦。目前这5个字段现在都可以封装到父类中去了哦，而且完全没有任何问题
		//  从工作量的角度来说，第一种更好，毕竟一次配置好，以后就一劳永逸了
		//  第二种，不仅要配置，还需要每张表手动的去设置，当然是第一个更好，更方便啦


	// 法二：表中的这两个字段设置默认时间值，且updateTime设置为自动更新，然后设置mp在插入和修改时忽略这个字段



	// insert时会填充此字段
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	// insert和update时都会填充字段
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	private String createBy;

	private String updateBy;

}
