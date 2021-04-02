package com.keqi.mybatisplusagain.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@TableName(value = "sys_account")
public class Account {

	/**
	 * 用户id
	 */
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	/*
		MP 的主键生成策略一共有4种
			1、NONE/INPUT：默认的机制，需要自己手动（自定义主键生成策略）的去填充主键，或者利用自动填充机制也行（你有比它更好算法的时候，推荐）
			2、AUTO：依赖于数据库的主键自增策略
			3、ASSIGN_ID 使用默认的雪花算法生成ID，支持 number 和 string 类型（推荐！！！）
			4、ASSIGN_UUID 使用UUID生成主键，只支持主键类型为 String 的
	 */
	private Long id;

	/**
	 * 用户名
	 */
	@TableField(value = "account")
	private String account;

	/**
	 * 姓名
	 */
	@TableField(value = "nick_name")
	// 默认情况下 MyBatisPlus 会自动的帮你把下划线转成驼峰，只要你代码中的字段和数据库中的字段都严格遵守这种规范
	private String nickName;

	/**
	 * 岗位
	 */
	@TableField(value = "post")
	private String post;

	/**
	 * 密码
	 */
	@TableField(value = "`password`")
	private String password;

	/**
	 * 盐
	 */
	@TableField(exist = false)
	private String salt;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 是否删除[0 未删除，1 已删除]
	 */
	@TableField(value = "deleted")
	private Integer deleted;
}