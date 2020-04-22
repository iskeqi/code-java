package com.keqi.apihu.manage.domain;

import com.keqi.apihu.manage.domain.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO implements Serializable {
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

	private static final long serialVersionUID = 1L;

	//========其他参数=============

	private UserTypeEnum userType;
}