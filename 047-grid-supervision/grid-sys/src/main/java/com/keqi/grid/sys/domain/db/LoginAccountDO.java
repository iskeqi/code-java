package com.keqi.grid.sys.domain.db;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 登录用户表
 */
@Data
public class LoginAccountDO {

	/**
	 * id
	 */
	private Long id;

	/**
	 * token
	 */
	private String token;

	/**
	 * 用户id
	 */
	private Long accountId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	public LoginAccountDO() {
	}

	public LoginAccountDO(String token, Long accountId) {
		this.token = token;
		this.accountId = accountId;
	}
}