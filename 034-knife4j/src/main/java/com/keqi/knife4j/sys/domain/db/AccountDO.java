package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}