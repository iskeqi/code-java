package com.keqi.apihu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountProjectDO implements Serializable {
	/**
	 * 用户ID
	 */
	private Long accountId;

	/**
	 * 项目ID
	 */
	private Long projectId;

	private static final long serialVersionUID = 1L;
}