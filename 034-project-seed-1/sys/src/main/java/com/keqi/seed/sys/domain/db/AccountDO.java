package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@TableName(value = "sys_account")
public class AccountDO {

	/**
	 * 用户id
	 */
	@TableId(value = "id", type = IdType.AUTO)
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
	@TableField(value = "`salt`")
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