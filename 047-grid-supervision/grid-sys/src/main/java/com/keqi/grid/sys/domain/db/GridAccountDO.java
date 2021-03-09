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

	public GridAccountDO() {
	}

	public GridAccountDO(Long accountId) {
		this.accountId = accountId;
	}

	public GridAccountDO(Long accountId, Long gridId) {
		this.accountId = accountId;
		this.gridId = gridId;
	}
}