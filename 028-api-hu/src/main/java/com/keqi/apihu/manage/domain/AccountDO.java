package com.keqi.apihu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO {
	private Long id;

	/**
	 * 用户账号
	 */
	private String account;

	/**
	 * 用户名称
	 */
	private String nickName;

	/**
	 * 岗位
	 */
	private String post;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	//========其他参数=============

	private UserTypeEnum userType;
}