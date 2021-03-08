package com.keqi.grid.sys.domain.db;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 网格表
 */
@Data
public class GridDO {

	/**
	 * 网格id
	 */
	private Long id;

	/**
	 * 网格名称
	 */
	private String name;

	/**
	 * 网格面积[单位：平方公里]
	 */
	private BigDecimal area;

	/**
	 * 排序字段
	 */
	private Integer orderNum;

	/**
	 * 父级ID
	 */
	private Long parentId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}