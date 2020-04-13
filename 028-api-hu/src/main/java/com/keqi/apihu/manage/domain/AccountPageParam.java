package com.keqi.apihu.manage.domain;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountPageParam {

	private String account;

	private String nickName;

	/**
	 * 当前页数（最小为1）
	 */
	private int pageNum = 1;

	/**
	 * 每页大小（最大为50）
	 */
	private int pageSize = 10;
}
