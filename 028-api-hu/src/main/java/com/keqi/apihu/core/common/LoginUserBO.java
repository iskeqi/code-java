package com.keqi.apihu.core.common;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUserBO {

	/**
	 * 登录用户账号名
	 */
	private String account;

	/**
	 * 登录用户姓名
	 */
	private String nickName;

	private String post;
}
