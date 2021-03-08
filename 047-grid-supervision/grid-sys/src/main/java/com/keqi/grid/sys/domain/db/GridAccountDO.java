package com.keqi.grid.sys.domain.db;

import lombok.Data;


/**
 * 网格-用户表
 */
@Data
public class GridAccountDO {

	/**
	 * 网格-用户关联表id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long accountId;

	/**
	 * 网格id
	 */
	private Long gridId;

}