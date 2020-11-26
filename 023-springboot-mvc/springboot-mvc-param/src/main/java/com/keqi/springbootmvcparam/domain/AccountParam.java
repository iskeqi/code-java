package com.keqi.springbootmvcparam.domain;

import lombok.*;

/**
 * 用户参数(新增/修改公用此Param类)
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountParam {

	// 新增时此参数无效，修改时必传
	private Long id;

	private String account;

	// 此参数可选(前端可能传递的是""或者是null)
	private String remark;

	// JSON 字符串
	private String jsonStr;
}
