package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_account")
public class AccountDO extends BaseDO {

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