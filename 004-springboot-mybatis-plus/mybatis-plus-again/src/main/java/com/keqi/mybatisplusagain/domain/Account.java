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
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户名
	 */
	//@TableField(value = "account")
	private String account;

	/**
	 * 姓名
	 */
	//@TableField(value = "nick_name")
	// 默认情况下 MyBatisPlus 会自动的帮你把下划线转成驼峰，只要你代码中的字段和数据库中的字段都严格遵守这种规范
	private String nickName;

	/**
	 * 岗位
	 */
	//@TableField(value = "post")
	private String post;

	/**
	 * 密码
	 */
	//@TableField(value = "`password`")
	private String password;

	/**
	 * 盐
	 */
	//@TableField(value = "`salt`")
	private String salt;

	/**
	 * 创建时间
	 */
	@TableField(/*value = "create_time", */fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(/*value = "update_time", */fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 是否删除[0 未删除，1 已删除]
	 */
	//@TableField(value = "deleted")
	private Integer deleted;
}