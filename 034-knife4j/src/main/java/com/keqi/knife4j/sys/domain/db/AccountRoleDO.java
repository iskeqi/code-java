package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户-角色表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_account_role")
public class AccountRoleDO {

	/**
	 * 用户ID
	 */
	@TableField(value = "account_id")
	private Long accountId;

	/**
	 * 角色ID
	 */
	@TableField(value = "role_id")
	private Long roleId;


}