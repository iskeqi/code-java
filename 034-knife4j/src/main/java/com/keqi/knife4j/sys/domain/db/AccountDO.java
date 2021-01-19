package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户表
 */
/*@EqualsAndHashCode(callSuper = true)*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_account")
public class AccountDO /*extends BaseDO*/ {

	@TableId(value = "id", type = IdType.AUTO)
	protected Long id;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	protected LocalDateTime createTime;

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
	 * 密码
	 */
	@TableField(value = "`password`")
	private String password;

	/**
	 * 盐
	 */
	@TableField(value = "`salt`")
	private String salt;
}